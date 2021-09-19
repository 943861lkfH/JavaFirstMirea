package ru.mirea.task3;

public class Circle {
    private int radius;
    public Circle(int radius){
        this.radius = radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public int getRadius(){
       return radius;
    }
    public void getDiameter(){
        System.out.println("Diameter = " + 2*radius);
    }
}
