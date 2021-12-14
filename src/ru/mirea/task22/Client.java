package ru.mirea.task22;

public class Client {

    public void sit(ChairFactory.ChairType type){
        ChairFactory factory = new ChairFactory();
        Chair chair = factory.createChair(type);
        chair.colour("Blue");
        chair.weight();
        System.out.println(chair.toString());
    }

    public static void main(String[] args) {
        ChairFactory.ChairType type = ChairFactory.ChairType.VictorianChair;
        Client client = new Client();
        client.sit(type);
    }
}
