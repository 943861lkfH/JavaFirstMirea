package ru.mirea.task3.Human;

public class Human {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Human(String n, int a, int w, int h) {
        name = n;
        age = a;
        weight = w;
        height = h;
    }

    public String getName(){ return name; }
    public int getAge() {return age; }
    public int getWeight() {return weight;}
    public int getHeight() { return height; }
    public String toString()
    {
        return this.name+" is "+this.age+"years old and weight is "+this.weight+ ", height is "+this.height+'\n';
    }
}
