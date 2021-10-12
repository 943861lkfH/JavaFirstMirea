package ru.mirea.task10.Num13;

import java.util.Scanner;

public class Recur13 {
    public static void main(String[] args) {
        Recur13 rec = new Recur13();
        rec.oddSequence();
    }
    public void oddSequence(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num==0) return;
        System.out.print(num+" ");
        num = in.nextInt();
        if(num==0) return;
        oddSequence();
    }
}
