package ru.mirea.task6.Priceable;

public class TestPriceable {
    public static void main(String[] ars){
        Book b = new Book();
        b.setPrice(2100);
        b.getInfo();
        Food f = new Food();
        f.setPrice(45);
        f.getInfo();
    }
}
