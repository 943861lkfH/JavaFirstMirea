package ru.mirea.task13;
import java.util.LinkedList;

public class LinkList {
    public static void main(String[] args){
        LinkedList <String> List = new LinkedList();
        List.add("Harry");
        List.add("Itan");
        List.add("Jozy");
        List.add(1,"Bob");
        String a = new String("Mary");
        List.add(0,a);
        for(String s : List){
            System.out.println(s);
        }
        if (List.contains("Mary"))
            System.out.println("Mary is here");
        else System.out.println("Mary is not here");
        List.removeFirst();
        List.removeLast();
        for (String s : List){
            System.out.println(s);
        }
        if (List.contains("Mary"))
            System.out.println("Mary is here");
        else System.out.println("Mary is not here");
        System.out.println("The first element is " + List.peekFirst());
        System.out.println("The Last element is " + List.peekLast());
    }
}
