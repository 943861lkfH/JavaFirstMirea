package Prac2;
import java.util.Scanner;

public class TestAuthor {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String name = in.next();
        String email = in.next();
        String g = in.next();
        char gender = g.charAt(0);
        Author a1 = new Author(name, email, gender);
        System.out.println(a1.toString());
    }
}
