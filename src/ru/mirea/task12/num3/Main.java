package ru.mirea.task12.num3;
import ru.mirea.task12.num1.Students;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Students> students1 = new ArrayList<Students>();
        ArrayList <Students> students2 = new ArrayList<Students>();
        Students student1 = new Students(12,"Sem","Brown",1);
        Students student2 = new Students(5,"Bob","Bob",2);
        Students student3 = new Students(10,"Mike","Shell",1);
        Students student4 = new Students(7,"Lora","Palmer",3);
        Students student5 = new Students(1,"Donna","Hayward",3);
        Students student6 = new Students(2,"Bobby","Briggs",4);
        Students student7 = new Students(8,"Natan","Brush",1);
        Students student8 = new Students(11,"Audrey","Horne",3);
        Students student9 = new Students(4,"Joan","Chen",2);
        Students student10 = new Students(3,"Henk","Jennings",2);
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);
        students2.add(student6);
        students2.add(student7);
        students2.add(student8);
        students2.add(student9);
        students2.add(student10);

}
