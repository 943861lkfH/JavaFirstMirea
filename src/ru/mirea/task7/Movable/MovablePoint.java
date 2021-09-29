package ru.mirea.task7.Movable;

public class MovablePoint implements Movable{
    public int y, x, xSpeed, ySpeed;

    public MovablePoint(int y, int x, int xSpeed, int ySpeed) {
        this.y = y;
        this.x = x;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {    }

    public String toString() {
        return "MovablePoint{" +
                "y=" + y +
                ", x=" + x +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }


    public void moveUpp() {
        x++;
    }

    public void moveDown() {
        x--;
    }

    public void moveLeft() {
        y--;
    }

    public void moveRight() {
        y++;
    }
}
