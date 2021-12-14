package ru.mirea.task26;

public class Main {
    public static void main(String[] args) {
        Purchase bread = new Bread(new OnlainWallet());
        bread.pay();
        Purchase cucumber = new Cucumber(new CreditCard());
        cucumber.pay();
    }
}
