package ru.mirea.task5.dish;

public class Pan extends Dish {
    private String form;
    public Pan(String material, String colour, String form){
        super(material,colour);
        this.form = form;
    }
    public void displayInfo(){
        System.out.println("Кастрюля из "+ super.getMaterial()+" "+super.getColor()+" цвета и "+ form+" формы");
    }
}
