package ru.mirea.task10.Num14;

import java.util.Scanner;

public class Recur14 {
    public static void main(String[] args) {
        Recur14 rec = new Recur14();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        rec.leftToRight(num);
    }
    public void leftToRight(int num){
        if (num == 0) return;

        leftToRight(num);
    }
}
