package ru.mirea.task25;

public class RedShapeDecorator extends ShapeDecorator{

    public Shape shape;

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw(){
        System.out.println("redShapeDecorator");
        setRedBorder();
    }

    private void setRedBorder(){
        System.out.println("redBorder");
    }
}
