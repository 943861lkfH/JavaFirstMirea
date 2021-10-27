package ru.mirea.task12.num3;
import ru.mirea.task12.num1.Students;


public class Main {

    static void print(Students[] array){
        for(int i = 0; i< array.length; i++)
            System.out.println(" "+array[i]);
    }

    public static void main(String[] args) {
        Students[] students1 = new Students[5];
        students1[0] = new Students(6,"Sem","Brown",3.5,1);
        students1[1] = new Students(5,"Bob","Bob", 4.0, 2);
        students1[2] = new Students(10,"Mike","Shell",4.7, 1);
        students1[3] = new Students(7,"Lora","Palmer",3.9, 3);
        students1[4] = new Students(1,"Donna","Hayward",2.8, 3);
        Students[] students2 = new Students[5];
        students2[0] = new Students(2,"Bobby","Briggs",4.65, 4);
        students2[1] = new Students(8,"Natan","Brush",4.33, 1);
        students2[2] = new Students(9,"Audrey","Horne",3.75, 3);
        students2[3] = new Students(4,"Joan","Chen",3.5, 2);
        students2[4] = new Students(3,"Henk","Jennings", 4.6, 2);
        Students[] result = new Students[10];
        System.arraycopy(students1, 0, result, 0, 5);
        System.arraycopy(students2, 0, result, 5, 5);
        MergeSort newSort = new MergeSort();
        Students[] result2 = newSort.Sort(result, 0, result.length - 1);
        print(result2);
    }
}
