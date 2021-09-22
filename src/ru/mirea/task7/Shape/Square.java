package ru.mirea.task7.Shape;

public class Square extends Shape {

    protected double side;
    public Square(){
        side = 0;
    }
    public Square(double side, String color, boolean filled){
        super(color,filled);
        this.side=side;
    }
    public double getArea(){
        return side*side;
    }
    public double getPerimeter() {
        return 4*side;
    }
    public String toString(){
        return ("Square, side = "+side+", colour = "+color+", filled - "+ filled);
    }
}
