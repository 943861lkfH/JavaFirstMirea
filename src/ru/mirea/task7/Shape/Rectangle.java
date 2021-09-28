package ru.mirea.task7.Shape;

public class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle() {
    }

    public Rectangle(String color, boolean filled){
        width = 0;
        length = 0;
    }
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return width*length;
    }

    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    public double getPerimeter() {
        return 2*width+2*length;
    }

}
