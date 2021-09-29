package ru.mirea.task7.Movable;

public class MovableRectangle implements Movable{
    public MovablePoint topLeft;
    public MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft.x = x1;
        topLeft.y = y1;
        bottomRight.x = x2;
        bottomRight.y = y2;

    }

    public void moveUpp() {
        x++;
    }

    @Override
    public void moveDown() {
        x--;
    }

    @Override
    public void moveLeft() {
        y--;
    }

    @Override
    public void moveRight() {
        y++;
    }
}
