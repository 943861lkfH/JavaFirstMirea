package ru.mirea.task26;

public class Purchase {
    private Payment payment;
    private int price;
    private String name;

    public Purchase(Payment payment, int price, String name){
        this.payment = payment;
        this.price = price;
        this.name = name;
    }

    public void pay(){
        System.out.println("Заказанный " + name + " ожидает оплату: " + price + " рублей");
        this.payment.pay();
    }
}
