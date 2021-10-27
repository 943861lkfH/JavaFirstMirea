package ru.mirea.task11;
import javax.swing.*;
import java.awt.*;

public class Num1 extends JFrame{
        JLabel lb = new JLabel("Введите число 1-20 ");
        JTextField t = new JTextField(10);
        JButton b = new JButton("Проверить");
        int n = 10;
        int times = 1;

        public Num1(){
            super("Введенный номер ");
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(400,300);
            setLayout(new FlowLayout());
            add(lb);
            add(t);
            add(b);

            b.addActionListener(e -> {
                if (times == 3 && Integer.parseInt(t.getText()) != n){
                    JOptionPane.showMessageDialog(null,"Вы проиграли. Правильный номер: " + n);
                    System.exit(0);
                }
                if(Integer.parseInt(t.getText()) == n)
                {
                    JOptionPane.showMessageDialog(null,"Вы выиграли!");
                    System.exit(0);
                }
                else if(Integer.parseInt(t.getText()) > n && times!= 3){
                    JOptionPane.showMessageDialog(null,"Неверно. Верный номер меньше вашего");
                    times++;
                }
                else if(Integer.parseInt(t.getText()) < n && times!= 3){
                    JOptionPane.showMessageDialog(null,"Неверно. Верный номер больше вашего");
                    times++;
                }
            });
        }

        public static void main (String[] args)
        {
            new Num1();
        }
}
