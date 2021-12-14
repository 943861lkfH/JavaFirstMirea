package ru.mirea.task25;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();

        Shape rectangle = new Rectangle();
        rectangle.draw();

        Shape redShapeDecorator = new RedShapeDecorator(circle);
        redShapeDecorator.draw();;

        Shape shapeDecorator = new ShapeDecorator(rectangle);
        shapeDecorator.draw();
    }
}
