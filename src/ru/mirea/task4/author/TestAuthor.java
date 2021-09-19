package ru.mirea.task4.author;
import java.util.Scanner;

public class TestAuthor {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String name = in.next(); // ввод имени
        String email = in.next();// ввод почты
        String g = in.next();// ввод гендера в переменную string
        char gender = g.charAt(0);// приведение типа string к char
        Author a1 = new Author(name, email, gender);
        System.out.println(a1.toString());
    }
}
