package ru.mirea.task2.Ball;

public class Ball {
    private int weight;
    private String type;

    public Ball(String type) {
        this.type = type;
        this.weight = 0;
    }
    public Ball(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
    public Ball(int weight) {
        this.weight = weight;
        this.type = "soccer";
    }
    public Ball() {
        type = "soccer";
        weight = 0;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public int getWeight() {
        return weight;
    }
    public String toString(){
        return this.type+", weight "+this.weight;
    }
    public void intoInfo(){
        System.out.println("the weight of a "+type+" ball is "+weight);
    }
}
