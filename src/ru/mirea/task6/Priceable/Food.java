package ru.mirea.task6.Priceable;

public class Food implements Priceable{
    private int price;
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void getInfo(){
        System.out.println("Plate this food is " + getPrice());
    }
}
