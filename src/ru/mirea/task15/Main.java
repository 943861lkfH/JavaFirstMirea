package ru.mirea.task15;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void inputFile(String fileName, boolean append){
        try {
            FileWriter file = new FileWriter(fileName, append);
            Scanner in = new Scanner(System.in);
            file.write(in.nextLine());
            file.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void inputFile(String fileName){
        try {
            FileWriter file = new FileWriter(fileName);
            Scanner in = new Scanner(System.in);
            file.write(in.nextLine());
            file.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void outputFile(String fileName){
        try(FileReader reader = new FileReader("C:/Users/Эльдорадо/IdeaProjects/JavaFirstMirea/src/ru/mirea/task15/fileJava.txt"))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.println(buf);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        String fileName = "C:/Users/Эльдорадо/IdeaProjects/JavaFirstMirea/src/ru/mirea/task15/fileJava.txt";
        inputFile(fileName); // запись в файл с клавиатуры
        outputFile(fileName); // чтение из файла
        inputFile(fileName, false); // замена информации в файле на введенную с клавиатуры
        outputFile(fileName);
        inputFile(fileName, true); // добавить в конец файла
        outputFile(fileName);
    }
}
