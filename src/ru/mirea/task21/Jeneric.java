package ru.mirea.task21;

import java.util.ArrayList;
import java.util.List;

public class Jeneric {

    public static void main(String[] args) {
        Metro<String> metro = new Metro<>();
        metro.getLine().add("Ploshad_Iliycha");
        metro.getLine().add("Serp_i_molot");
        metro.getLine().add("Borovitskaya");
        metro.getLine().add("Pervomaiskaya");
        metro.getLine().add("Kievskaya");
        metro.getLine().add("Aviamotornaya");
        metro.PrintList(true);      //нечетная
        System.out.println();
        metro.PrintList(false);     //четная
    }

}

class Metro<T>{

    List<T> line = new ArrayList<>();

    public void PrintList(boolean b){
        if(b)
        {
            for(int i = 0; i < line.size(); i+=2)
             System.out.println(line.get(i));
        }
        else
        {
            for(int i = 1; i < line.size(); i+=2)
                System.out.println(line.get(i));
        }
    }

    public List<T> getLine(){
        return line;
    }
}
