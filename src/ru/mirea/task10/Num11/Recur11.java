package ru.mirea.task10.Num11;

import java.util.Scanner;

public class Recur11 {
    public static void main(String[] args) {
        Recur11 rec = new Recur11();
        System.out.print(rec.count());
    }
   public int count(){
       Scanner in = new Scanner(System.in);
       int num = in.nextInt();
       if(num==0)
           num = in.nextInt();
       if(num==0) return 0;
       return 1 + count();
    }
}
