package ru.mirea.task7.Movable;

public class MovableRectangle implements Movable{
    public MovablePoint topLeft = new MovablePoint();
    public MovablePoint bottomRight = new MovablePoint();

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft.x = x1;
        topLeft.y = y1;
        bottomRight.x = x2;
        bottomRight.y = y2;

    }

    public void moveUpp() {
        topLeft.x++;
        bottomRight.x++;
    }

    public void moveDown() {
        topLeft.x--;
        bottomRight.x--;
    }

    public void moveLeft() {
        topLeft.y--;
        bottomRight.y--;
    }

    public void moveRight() {
        topLeft.y++;
        bottomRight.y++;
    }

    public String toString() {
        return "MovableRectangle{" +
                "topLeft (x, y) = " + topLeft.x + ", "+ topLeft.y +
                ", xSpeed topLeft = " + topLeft.xSpeed + ", ySpeed topLeft = " + topLeft.ySpeed +
                ", bottomRight = " + bottomRight.x + ", "+ bottomRight.y +
                ", xSpeed bottomRight = " + bottomRight.xSpeed + ", ySpeed bottomRight = " + bottomRight.ySpeed +
                '}';
    }
}
