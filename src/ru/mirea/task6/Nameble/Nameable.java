package ru.mirea.task6.Nameble;

public interface Nameable {
    public String getName(String name);
    public default void getInfo(){
        System.out.print("This is ");
    }
}
