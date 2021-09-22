package ru.mirea.task7.Shape;

public class Rectangle extends Shape{
    protected double width;
    protected double length;
    public Rectangle(){
        width = 0;
    }
    public Rectangle(double radius){
        this.radius = radius;
    }
    public Rectangle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    public String toString(){
        return ("Circle, radius = "+radius+", colour = "+color+", filled - "+ filled);
    }
}
