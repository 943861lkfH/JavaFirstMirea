package ru.mirea.task10.Num15;

import java.util.Scanner;

public class Recur15 {
    public static void main(String[] args) {
        Recur15 rec = new Recur15();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        rec.rightToLeft(num);
    }
    public void rightToLeft(int num){
        if (num == 0) return;
        System.out.print(num%10+" ");
        num = num/10;
        rightToLeft(num);
    }
}
