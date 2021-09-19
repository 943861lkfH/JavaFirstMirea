package ru.mirea.task5.dish;

public class Main {
    public static void main(String[] args){
        Pan pan = new Pan("чугун","черный","блинница");
        Plate plate = new Plate("форфор","прозрачный","плоская");
        pan.displayInfo();
        plate.displayInfo();
    }
}
