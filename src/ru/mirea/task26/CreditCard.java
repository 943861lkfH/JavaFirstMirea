package ru.mirea.task26;

public class CreditCard implements Payment{
    @Override
    public void pay() {
        System.out.println("Оплата кредитной картой");
    }
}
