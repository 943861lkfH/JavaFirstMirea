package ru.mirea.task4.ball;

public class BallTest {
    public static void main(String[] args) {
        Ball ball = new Ball(10, 16);
        System.out.println(ball);
        ball.move(10, 4);
        System.out.println(ball);
    }
}
