package ru.mirea.task11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Num2 {
    public static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane() {

        JFrame frame = new JFrame("BorderLayoutDemo");
        frame.setSize(800,800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button = new JButton("NORTH");
        pane.add(button, BorderLayout.PAGE_START);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JDialog dialog = new JDialog(frame,"You are in NORTH");
                dialog.setSize(200,200);
                dialog.setVisible(true);
            }
        });

        button = new JButton("CENTER");
        button.setPreferredSize(new Dimension(200, 100));
        pane.add(button, BorderLayout.CENTER);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JDialog dialog = new JDialog(frame,"You are in CENTER");
                dialog.setSize(200,200);
                dialog.setVisible(true);
            }
        });

        button = new JButton("WEST");
        pane.add(button, BorderLayout.LINE_START);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JDialog dialog = new JDialog(frame,"You are in WEST");
                dialog.setSize(200,200);
                dialog.setVisible(true);
            }
        });

        button = new JButton("SOUTH");
        pane.add(button, BorderLayout.PAGE_END);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JDialog dialog = new JDialog(frame,"You are in SOUTH");
                dialog.setSize(200,200);
                dialog.setVisible(true);
            }
        });

        button = new JButton("EAST");
        pane.add(button, BorderLayout.LINE_END);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JDialog dialog = new JDialog(frame,"You are in EAST");
                dialog.setSize(200,200);
                dialog.setVisible(true);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    /*private static void createAndShowGUI() {
        JFrame frame = new JFrame("BorderLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }*/

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                addComponentsToPane();
            }
        });
    }
}
