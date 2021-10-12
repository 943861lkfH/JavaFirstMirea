package ru.mirea.task10.Num12;

import java.util.Scanner;

public class Recur12 {
    public static void main(String[] args) {
        Recur12 rec = new Recur12();
        rec.oddSequence();
    }
   public void oddSequence(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num==0) return;
        else if (num % 2 != 0)
            System.out.print(num+" ");
        oddSequence();
    }
}
