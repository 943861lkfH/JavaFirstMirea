package ru.mirea.task1.opt6;
import java.util.Random;

public class Array {
    private int[] array;
    public Array(){
    }
    public void rand1(){
        this.array = new int[10];
        for(int i = 0; i < array.length;i++)
            array[i] = (int)(Math.random()*100);
    }
    public void rand2(){
        this.array = new int[10];
        Random rand = new Random();
        for(int i = 0; i < array.length;i++)
            array[i] = rand.nextInt(100);
    }
    public void setArray(){
        for (int i = 0; i < array.length; i++)
            System.out.print(" "+(array[i]));
    }
    public void sort(){
        for(int left = 0; left < array.length; left ++) { // от нуля до конца массива
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i])
                    array[i + 1] = array[i];
                else break;
            }
            array[i+1]=value;
        }
    }
}
