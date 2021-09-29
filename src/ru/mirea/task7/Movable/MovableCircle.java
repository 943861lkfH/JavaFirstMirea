package ru.mirea.task7.Movable;

public class MovableCircle implements Movable {
    public int radius;
    public MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center.x = x;
        center.y = y;
        center.xSpeed = xSpeed;
        center.ySpeed = ySpeed;
        this.radius = radius;
    }

    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    public void moveUpp() {
        center.x++;
    }

    public void moveDown() {
        center.x--;
    }

    public void moveLeft() {
        center.y--;
    }

    public void moveRight() {
        center.y++;
    }
}
