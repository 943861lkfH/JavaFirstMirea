package ru.mirea.task7.Movable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(20, 8, 12, 0);
        point.moveDown();
        point.moveRight();
        MovableCircle circle = new MovableCircle(1,1,1,1, 5);
        MovableRectangle rectangle = new MovableRectangle(0, 10,10,10,2,1);
        System.out.println(point.toString());
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
    }
}
