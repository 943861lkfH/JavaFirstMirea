package ru.mirea.task22;

public class VictorianChair implements Chair{

    private String colour;
    private int weight;
    @Override
    public void colour(String colour) {
        this.colour = colour;
    }

    @Override
    public void weight() {
        weight = 25;
    }

    @Override
    public String toString() {
        return "VictorianChair{" +
                "colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }
}
