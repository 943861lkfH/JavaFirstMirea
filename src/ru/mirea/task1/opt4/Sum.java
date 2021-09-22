package ru.mirea.task1.opt4;

public class Sum {
    private int[] array;
    private int sum;
    public Sum(){
    }
    public void rand(){
        this.array = new int[10];
        for(int i = 0; i < array.length;i++)
            array[i] = (int)(Math.random()*100);
    }
    public void setArray(){
        for (int i = 0; i < array.length; i++)
            System.out.print(" "+(array[i]));
    }
    public void For(){
        sum = 0;
        for(int i = 0; i < 10; i++)
            sum+=array[i];
    }
    public void While(){
        sum = 0;
        int i = 0;
        while (i<10) {
            sum += array[i];
            i++;
        }
    }
    public void DoWhile(){
        sum = 0;
        int i = 0;
         do{
            sum += array[i];
            i++;
        }while (i<10);
    }
    public void getSum(){
        System.out.println("Sum = " + sum);
    }
}
