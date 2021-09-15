package ru.mirea.task2.Book;

import Ball.Ball;

public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("The bible", 666);
        Book b2 = new Book("No name", 102);
        Book b3 = new Book("To the moon");
        System.out.println(b1);
        b1.intoInfo();
        b2.intoInfo();
        b3.intoInfo();
    }
}
