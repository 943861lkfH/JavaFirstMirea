package ru.mirea.task6;

public class Girl implements Nameable {
    public String getName(String name){
        return name;
    }
    public static void main(String[] ars){
        Girl girl1 = new Girl();
        girl1.getInfo();
        System.out.println(girl1.getName("Julia"));

        Girl girl2 = new Girl();
        girl2.getInfo();
        System.out.println(girl2.getName("Mila"));

    }
}
