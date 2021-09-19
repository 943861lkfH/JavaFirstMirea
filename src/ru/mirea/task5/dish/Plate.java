package ru.mirea.task5.dish;

public class Plate extends Dish {
    private String form;
    public Plate(String material, String colour, String form){
        super(material,colour);
        this.form = form;
    }
    public void displayInfo(){
        System.out.println("Тарелка из "+ super.getMaterial()+" "+super.getColor()+" цвета и "+ form+" формы");
    }
}
