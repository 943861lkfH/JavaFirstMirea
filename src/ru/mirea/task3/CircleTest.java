package ru.mirea.task3;

public class CircleTest {
    public static void main(String[] ars){
        Circle cir = new Circle(0);
        cir.setRadius(12);
        System.out.println("Radius = " + cir.getRadius());
        cir.getDiameter();
    }
}
