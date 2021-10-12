package ru.mirea.task10.Num10;

import java.util.Scanner;

public class Recur10 {
    public static void main(String[] args) {
        Recur10 rec = new Recur10();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print("n -> " + rec.turn(n, 0));
    }
    public int turn(int n, int i){
        if(n/10==0) return i*10 + n;
        return turn(n/10,i*10 + n%10 );
    }
}
