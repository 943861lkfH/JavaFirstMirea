package ru.mirea.task2.Ball;

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball(8, "volleyball");
        Ball b2 = new Ball(1, "tennis");
        Ball b3 = new Ball(10);
        System.out.println(b1);
        b1.intoInfo();
        b2.intoInfo();
        b3.intoInfo();
    }
}
