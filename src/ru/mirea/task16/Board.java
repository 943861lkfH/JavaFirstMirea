package ru.mirea.task16;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


    public class Board extends JPanel implements ActionListener {

        private Dimension d;
        private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

        private Image ii;
        private final Color dotColor = new Color(192, 192, 0);
        private Color mazeColor;

        private boolean inGame = false;
        private boolean dying = false;

        private final int BLOCK_SIZE = 24;
        private final int N_BLOCKS = 15;
        private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
        private final int PAC_ANIM_DELAY = 2;
        private final int PACMAN_ANIM_COUNT = 4;
        private final int MAX_GHOSTS = 12;
        private final int PACMAN_SPEED = 6;

        private int pacAnimCount = PAC_ANIM_DELAY;
        private int pacAnimDir = 1;
        private int pacmanAnimPos = 0;
        private int N_GHOSTS = 6;
        private int pacsLeft, score;
        private int[] dx, dy;
        private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;



        public enum Speed{
            high(8),
            medium(6),
            average(4),
            slow(2);
            int speed;
            Speed(int speed){
                this.speed = speed;
            }
        }

        private Image ghost;
        private Image pacman1, pacman2up, pacman2left, pacman2right, pacman2down;
        private Image pacman3up, pacman3down, pacman3left, pacman3right;
        private Image pacman4up, pacman4down, pacman4left, pacman4right;

        private int pacman_x, pacman_y, pacmand_x, pacmand_y;
        private int req_dx, req_dy, view_dx, view_dy;

        private int level = 0;
        private long startTime;
        private long elapsedTime;
        private long elapsedSeconds = 0;

        private static HashMap<String, Integer> ghostss = new HashMap<>();

        private final short levelData[] = {
                19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
                21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                21, 0, 0, 0, 17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,
                17, 18, 18, 18, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 20,
                17, 16, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 16, 24, 20,
                25, 16, 16, 16, 24, 24, 28, 0, 25, 24, 24, 16, 20, 0, 21,
                1, 17, 16, 20, 0, 0, 0, 0, 0, 0, 0, 17, 20, 0, 21,
                1, 17, 16, 16, 18, 18, 22, 0, 19, 18, 18, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0, 21,
                1, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 21,
                1, 25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
                9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 25, 24, 24, 24, 28
        };

        private final int validSpeeds[] = {Speed.slow.speed, Speed.slow.speed,Speed.average.speed, Speed.average.speed,  Speed.medium.speed, Speed.medium.speed, Speed.medium.speed, Speed.high.speed};
        private final int maxSpeed = 6;

        private int currentSpeed = 3;
        private short[] screenData;
        private Timer timer;

        public Board() {

            loadImages();
            initVariables();
            initBoard();
        }

        private void initBoard() {

            addKeyListener(new TAdapter());

            setFocusable(true);

            setBackground(Color.black);
        }

        private void initVariables() {

            screenData = new short[N_BLOCKS * N_BLOCKS];
            mazeColor = new Color(5, 100, 5);
            d = new Dimension(400, 400);
            ghost_x = new int[MAX_GHOSTS];
            ghost_dx = new int[MAX_GHOSTS];
            ghost_y = new int[MAX_GHOSTS];
            ghost_dy = new int[MAX_GHOSTS];
            ghostSpeed = new int[MAX_GHOSTS];
            dx = new int[4];
            dy = new int[4];

            timer = new Timer(40, this);
            timer.start();
        }

        private static void setImage() {

            ghostss.put("PAC_ANIM_DELAY", 2);
            ghostss.put("PACMAN_ANIM_COUNT", 4);
            ghostss.put("MAX_GHOSTS", 12);
            ghostss.put("PACMAN_SPEED", 6);
            ghostss.put("pacAnimDir", 1);
            ghostss.put("pacmanAnimPos", 0);
        }
        public static HashMap<String, Integer> Ghost(){
            setImage();
            return ghostss;
        }

        @Override
        public void addNotify() {
            super.addNotify();

            initGame();
        }

        private void doAnim() {

            pacAnimCount--;

            if (pacAnimCount <= 0) {
                pacAnimCount = PAC_ANIM_DELAY;
                pacmanAnimPos = pacmanAnimPos + pacAnimDir;

                if (pacmanAnimPos == (PACMAN_ANIM_COUNT - 1) || pacmanAnimPos == 0) {
                    pacAnimDir = -pacAnimDir;
                }
            }
        }
        protected void death() {
            System.out.println("death");
        }

        private void playGame(Graphics2D g2d) {

            if (dying) {
                Board bo = new Board(){

                    @Override
                    protected void death() {

                        pacsLeft--;

                        if (pacsLeft == 0) {
                            inGame = false;
                        }

                        continueLevel();
                    }

                };
                bo.death();

            } else {

                movePacman();
                drawPacman(g2d);
                moveGhosts(g2d);
                checkMaze(g2d);
            }
        }

        private void showIntroScreen(Graphics2D g2d) {

            g2d.setColor(new Color(0, 32, 48));
            g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
            g2d.setColor(Color.white);
            g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

            String s = "Press s to start";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g2d.setColor(Color.white);
            g2d.setFont(small);
            g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
        }

        private void drawScore(Graphics2D g) {

            int i;
            String s;

            g.setFont(smallFont);
            g.setColor(new Color(96, 128, 255));
            if(pacsLeft != 0) {
                elapsedTime = System.currentTimeMillis() - startTime;
                elapsedSeconds = elapsedTime / 1000;
            }
            else elapsedSeconds = 0;

            s = "Score: " + score + "  Time: " + elapsedSeconds;
            g.drawString(s, SCREEN_SIZE / 2 + 35, SCREEN_SIZE + 16);

            for (i = 0; i < pacsLeft; i++) {
                g.drawImage(pacman3left, i * 28 + 8, SCREEN_SIZE + 1, this);
            }
        }

        private void checkMaze(Graphics2D g2d) {

            short i = 0;
            boolean finished = true;

            while (i < N_BLOCKS * N_BLOCKS && finished) {

                if ((screenData[i] & 48) != 0) {
                    finished = false;
                }

                i++;
            }

            if (finished) {

                score += 50;

                if (N_GHOSTS < MAX_GHOSTS) {
                    N_GHOSTS++;
                }

                if (currentSpeed < maxSpeed) {
                    currentSpeed++;
                }

                g2d.drawImage(ii, 5, 5, this);
                Toolkit.getDefaultToolkit().sync();
                g2d.dispose();
                initLevel();
            }
        }


        private void moveGhosts(Graphics2D g2d) {

            short i;
            int pos;
            int count;

            for (i = 0; i < N_GHOSTS; i++) {
                if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) {
                    pos = ghost_x[i] / BLOCK_SIZE + N_BLOCKS * (int) (ghost_y[i] / BLOCK_SIZE);

                    count = 0;

                    if ((screenData[pos] & 1) == 0 && ghost_dx[i] != 1) {
                        dx[count] = -1;
                        dy[count] = 0;
                        count++;
                    }

                    if ((screenData[pos] & 2) == 0 && ghost_dy[i] != 1) {
                        dx[count] = 0;
                        dy[count] = -1;
                        count++;
                    }

                    if ((screenData[pos] & 4) == 0 && ghost_dx[i] != -1) {
                        dx[count] = 1;
                        dy[count] = 0;
                        count++;
                    }

                    if ((screenData[pos] & 8) == 0 && ghost_dy[i] != -1) {
                        dx[count] = 0;
                        dy[count] = 1;
                        count++;
                    }

                    if (count == 0) {

                        if ((screenData[pos] & 15) == 15) {
                            ghost_dx[i] = 0;
                            ghost_dy[i] = 0;
                        } else {
                            ghost_dx[i] = -ghost_dx[i];
                            ghost_dy[i] = -ghost_dy[i];
                        }

                    } else {

                        count = (int) (Math.random() * count);

                        if (count > 3) {
                            count = 3;
                        }

                        ghost_dx[i] = dx[count];
                        ghost_dy[i] = dy[count];
                    }

                }

                ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeed[i]);
                ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeed[i]);
                drawGhost(g2d, ghost_x[i] + 1, ghost_y[i] + 1);

                if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                        && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                        && inGame) {

                    dying = true;
                }
            }
        }

        private void drawGhost(Graphics2D g2d, int x, int y) {

            g2d.drawImage(ghost, x, y, this);
        }

        private void movePacman() {

            int pos;
            short ch;

            if (Board.this.req_dx == -pacmand_x && req_dy == -pacmand_y) {
                pacmand_x = req_dx;
                pacmand_y = req_dy;
                view_dx = pacmand_x;
                view_dy = pacmand_y;
            }

            if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
                pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);
                ch = screenData[pos];

                if ((ch & 16) != 0) {
                    screenData[pos] = (short) (ch & 15);
                    score++;
                }

                if (req_dx != 0 || req_dy != 0) {
                    if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                            || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                            || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                            || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                        pacmand_x = req_dx;
                        pacmand_y = req_dy;
                        view_dx = pacmand_x;
                        view_dy = pacmand_y;
                    }
                }

                // Check for standstill
                if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                        || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                        || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                        || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                    pacmand_x = 0;
                    pacmand_y = 0;
                }
            }
            pacman_x = pacman_x + PACMAN_SPEED * pacmand_x;
            pacman_y = pacman_y + PACMAN_SPEED * pacmand_y;
        }

        private void drawPacman(Graphics2D g2d) {

            if (view_dx == -1) {
               drawPacnanLeft(g2d);
            } else if (view_dx == 1) {
                drawPacmanRight(g2d);
            } else if (view_dy == -1) {
                drawPacmanUp(g2d);
            } else {
                drawPacmanDown(g2d);
            }
        }

        private void drawPacmanUp(Graphics2D g2d) {

            switch (pacmanAnimPos) {
                case 1:
                    g2d.drawImage(pacman2up, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 2:
                    g2d.drawImage(pacman3up, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 3:
                    g2d.drawImage(pacman4up, pacman_x + 1, pacman_y + 1, this);
                    break;
                default:
                    g2d.drawImage(pacman1, pacman_x + 1, pacman_y + 1, this);
                    break;
            }
        }

        private void drawPacmanDown(Graphics2D g2d) {

            switch (pacmanAnimPos) {
                case 1:
                    g2d.drawImage(pacman2down, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 2:
                    g2d.drawImage(pacman3down, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 3:
                    g2d.drawImage(pacman4down, pacman_x + 1, pacman_y + 1, this);
                    break;
                default:
                    g2d.drawImage(pacman1, pacman_x + 1, pacman_y + 1, this);
                    break;
            }
        }

        private void drawPacnanLeft(Graphics2D g2d) {

            switch (pacmanAnimPos) {
                case 1:
                    g2d.drawImage(pacman2left, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 2:
                    g2d.drawImage(pacman3left, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 3:
                    g2d.drawImage(pacman4left, pacman_x + 1, pacman_y + 1, this);
                    break;
                default:
                    g2d.drawImage(pacman1, pacman_x + 1, pacman_y + 1, this);
                    break;
            }
        }

        private void drawPacmanRight(Graphics2D g2d) {

            switch (pacmanAnimPos) {
                case 1:
                    g2d.drawImage(pacman2right, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 2:
                    g2d.drawImage(pacman3right, pacman_x + 1, pacman_y + 1, this);
                    break;
                case 3:
                    g2d.drawImage(pacman4right, pacman_x + 1, pacman_y + 1, this);
                    break;
                default:
                    g2d.drawImage(pacman1, pacman_x + 1, pacman_y + 1, this);
                    break;
            }
        }


        private void drawMaze(Graphics2D g2d) {

            short i = 0;
            int x, y;

            for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
                for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                    g2d.setColor(mazeColor);
                    g2d.setStroke(new BasicStroke(2));

                    if ((screenData[i] & 1) != 0) {
                        g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 2) != 0) {
                        g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                    }

                    if ((screenData[i] & 4) != 0) {
                        g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                                y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 8) != 0) {
                        g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                                y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 16) != 0) {
                        g2d.setColor(dotColor);
                        g2d.fillRect(x + 11, y + 11, 2, 2);
                    }

                    i++;
                }
            }
        }

        private void initGame() {

            pacsLeft = 3;
            score = 0;
            initLevel();
            N_GHOSTS = 6;
            currentSpeed = 3;
            startTime = System.currentTimeMillis();
        }

        private void initLevel() {

            for (int i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
                screenData[i] = levelData[i];
            }

            continueLevel();
        }

        private void continueLevel() {

            short i;
            int dx = 1;
            int random;

            for (i = 0; i < N_GHOSTS; i++) {

                ghost_y[i] = 4 * BLOCK_SIZE;
                ghost_x[i] = 4 * BLOCK_SIZE;
                ghost_dy[i] = 0;
                ghost_dx[i] = dx;
                dx = -dx;
                random = (int) (Math.random() * (currentSpeed + 1));

                if (random > currentSpeed) {
                    random = currentSpeed;
                }

                ghostSpeed[i] = validSpeeds[random];
            }

            pacman_x = 7 * BLOCK_SIZE;
            pacman_y = 11 * BLOCK_SIZE;
            pacmand_x = 0;
            pacmand_y = 0;
            req_dx = 0;
            req_dy = 0;
            view_dx = -1;
            view_dy = 0;
            dying = false;
        }

        private void loadImages(){
            try {
                ghost = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//ghost.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman1 = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacman.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman2up = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanUp2.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman3up = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanUp3.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman4up = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanUp4.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman2down = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanDown2.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman3down = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanDown3.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman4down = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanDown4.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman2left = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanLeft2.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman3left = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanLeft3.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman4left = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacmanLeft4.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman2right = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacman2.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman3right = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacman3.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                pacman4right = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//pacman4.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            }
            catch(Exception ex){
                System.out.println(ex.getMessage() + "image is not found");
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            doDrawing(g);
        }

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, d.width, d.height);

            drawMaze(g2d);
            drawScore(g2d);
            doAnim();

            if (inGame) {
                playGame(g2d);
            } else {
                level = 1;
                showIntroScreen(g2d);
            }

            g2d.drawImage(ii, 5, 5, this);
            Toolkit.getDefaultToolkit().sync();
            g2d.dispose();
        }

        class TAdapter extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if (inGame) {
                    if (key == KeyEvent.VK_LEFT) {
                        req_dx = -1;
                        req_dy = 0;
                    } else if (key == KeyEvent.VK_RIGHT) {
                        req_dx = 1;
                        req_dy = 0;
                    } else if (key == KeyEvent.VK_UP) {
                        req_dx = 0;
                        req_dy = -1;
                    } else if (key == KeyEvent.VK_DOWN) {
                        req_dx = 0;
                        req_dy = 1;
                    } else if (key == KeyEvent.VK_ESCAPE) {
                        try{
                            if(!timer.isRunning())
                                throw new MyExeptionClass();
                        }
                        catch(MyExeptionClass exp)
                        {
                            System.out.println("Exception: "+exp.toString());
                        }
                        inGame = false;
                    }
                        if (key == KeyEvent.VK_PAUSE) {
                            if (timer.isRunning()) {
                                timer.stop();
                            } else {
                                timer.start();
                            }
                        }

                } else {
                    if (key == 's' || key == 'S') {

                        inGame = true;
                        initGame();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

                int key = e.getKeyCode();

                if (key == Event.LEFT || key == Event.RIGHT
                        || key == Event.UP || key == Event.DOWN) {
                    req_dx = 0;
                    req_dy = 0;
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            repaint();
        }
    }