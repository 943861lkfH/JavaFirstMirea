package ru.mirea.task13;
import java.util.ArrayList;

public class ArrList {
    public static void main(String[] args){
        ArrayList <String> List = new ArrayList();
        List.add("Harry");
        List.add("Itan");
        List.add("Jozy");
        System.out.println("Size = " + List.size() + " elements");
        for (String s:List){
            System.out.println(s);
        }
        if (List.contains("Harry"))
            System.out.println("Harry is here");
        else System.out.println("Harry is not here");
        if (List.contains("Itan"))
            System.out.println("Itan is here");
        else System.out.println("Itan is not here");
        if (List.contains("Jozy"))
            System.out.println("Jozy is here");
        else System.out.println("Jozy is not here");
        List.remove("Harry");
        System.out.println("In list we have " + List.size() + " element(s)");
        for (String s:List){
            System.out.println(s);
        }
        if (List.contains("Harry"))
            System.out.println("Harry is here");
        else System.out.println("Harry is not here");

    }
}
