package ru.mirea.task22;

public class MagicChair implements Chair{

    private String colour;
    private int weight;
    @Override
    public void colour(String colour) {
        this.colour=colour;
    }

    @Override
    public void weight() {
        weight = 0;
    }

    @Override
    public String toString() {
        return "MagicChair{" +
                "colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }
}
