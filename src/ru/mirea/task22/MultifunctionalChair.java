package ru.mirea.task22;

public class MultifunctionalChair implements Chair{

    private String colour;
    private int weight;
    @Override
    public void colour(String colour) {
        this.colour = colour;
    }

    @Override
    public void weight() {
        weight = 10;
    }

    @Override
    public String toString() {
        return "MultifunctionalChair{" +
                "colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }
}
