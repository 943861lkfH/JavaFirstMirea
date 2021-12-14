package ru.mirea.task26;

public class OnlainWallet implements Payment{

    @Override
    public void pay() {
        System.out.println("Оплата электронным кошельком");
    }
}
