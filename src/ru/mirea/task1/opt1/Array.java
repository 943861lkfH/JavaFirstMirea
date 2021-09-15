package Laba1;

public class Array {
    private int[] array;
    public Array(){
        this.array = new int[10];
        for(int i = 0; i<array.length;i++)
            array[i] = (int)(Math.random()*100);
    }
    public void setArray(){
        for (int i = 0; i < array.length; i++)
            System.out.print(" "+(array[i]));
    }
    public void sort(){
        for(int left = 0; left < array.length; left ++) {
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
