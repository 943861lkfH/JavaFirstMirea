package ru.mirea.task10.Num17;

import java.util.Scanner;

public class Recur17 {
    public static void main(String[] args) {
        Recur17 rec = new Recur17();
        System.out.print("Max = " + rec.max());
    }
    public int max(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 0) return 0;
        int max = max();
        if(num < max)
            return max;
        else return num;
    }
}
