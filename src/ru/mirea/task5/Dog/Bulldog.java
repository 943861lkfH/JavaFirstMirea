package ru.mirea.task5.Dog;

public class Bulldog extends Dog {
    private String Bulldog;
    public Bulldog(String n, int w, String b) {
        super("Billy",18);
        Bulldog=b;
    }
    public void setBulldog(String Bulldog) {
        this.Bulldog = Bulldog;
    }
    public String getBulldog()
    {
        return Bulldog;
    }
    public String toString()
    {
        return getName()+", weight "+getWeight()+" , bulldog "+getBulldog();
    }

}
