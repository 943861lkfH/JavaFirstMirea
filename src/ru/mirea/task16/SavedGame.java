package ru.mirea.task16;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class SavedGame implements Serializable {
    private static final long serialVersionUID = 1L;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    private final int MAX_GHOSTS = 12;
    private int[] dx, dy;
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private int N_GHOSTS = 6;
    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private short[] screenData;
    private boolean inGame = false;
    private boolean dying = false;
    private transient Image ghost = new ImageIcon("C://Users//Эльдорадо//OneDrive//Документы//Университет//pacman_game//ghost.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

    public SavedGame(Ghost ghost){
        this.ghost_x = ghost.ghost_x;
        this.ghost_dx = ghost.ghost_dx;
        this.ghost_y = ghost.ghost_y;
        this.ghost_dy = ghost.ghost_dy;
        this.ghostSpeed = ghost.ghostSpeed;
    }

    private void initVariables() {
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
    }
    @Override
    public String toString() {
        return "SavedGame{" +
                "ghost_x=" + ghost_x[0]+" " + ghost_x[1]+" "+ ghost_x[2]+" "+ ghost_x[3]+" "+ ghost_x[4]+" "+ ghost_x[5]+" "+
                ", ghost_dx=" + ghost_dx[0] + " "+ ghost_dx[1] + " " + ghost_dx[2] + " "+ ghost_dx[3] + " "+ghost_dx[4] + " " + ghost_dx[5] + " " +
                ", ghost_y=" + ghost_y[0] + " " + ghost_y[1] + " "+ ghost_y[2] + " "+ ghost_y[3] + " "+ ghost_y[4] + " "+ ghost_y[5] + " "+
                ", ghost_dy=" + ghost_dy[0] + " "+ ghost_dy[1] + " "+ ghost_dy[2] + " "+ ghost_dy[3] + " "+ ghost_dy[4] + " "+ ghost_dy[5] + " "+
                ", ghostSpeed" + ghostSpeed[0] + " "+ ghostSpeed[1] + " "+ ghostSpeed[2] + " "+ ghostSpeed[3] + " "+ ghostSpeed[4] + " "+ ghostSpeed[0] + " "+ ghostSpeed[5] +
                '}';
    }

    private void moveGhosts() {

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

            if (pacman_x > (ghost_x[i] - 12) && pacman_x < (ghost_x[i] + 12)
                    && pacman_y > (ghost_y[i] - 12) && pacman_y < (ghost_y[i] + 12)
                    && inGame) {

                dying = true;
            }
        }
    }
}
class Ghost{
    public int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    public Ghost(int[] ghost_x, int[] ghost_y, int[] ghost_dx, int[] ghost_dy, int[] ghostSpeed){
        this.ghost_x = ghost_x;
        this.ghost_dx = ghost_dx;
        this.ghost_y = ghost_y;
        this.ghost_dy = ghost_dy;
        this.ghostSpeed = ghostSpeed;
    }

}

class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[] ghost_x = new int[6];
        int[] ghost_dx = new int[6];
        int[] ghost_y = new int[6];
        int[] ghost_dy = new int[6];
        int[] ghostSpeed = new int[6];
        for(int i = 0; i < 6; i++)
        {
            ghost_x[i] = (new Random()).nextInt(8);
            ghost_dx[i] = (new Random()).nextInt(8);
            ghost_y[i] = (new Random()).nextInt(8);
            ghost_dy[i] = (new Random()).nextInt(8);
            ghostSpeed[i] = (new Random()).nextInt(8);
        }
        SavedGame savedGame = new SavedGame(new Ghost(ghost_x, ghost_dx, ghost_y, ghost_dy, ghostSpeed));
        FileOutputStream outputStream = new FileOutputStream("C://Users//Эльдорадо//IdeaProjects//JavaFirstMirea//src//ru//mirea//task16//save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(savedGame);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C://Users//Эльдорадо//IdeaProjects//JavaFirstMirea//src//ru//mirea//task16//save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SavedGame saveGame = (SavedGame) objectInputStream.readObject();

        objectInputStream.close();
        System.out.println(saveGame);
    }
}