package ru.mirea.task22;

public class ChairFactory {

    public enum ChairType {
        MultifunctionalChair,
        MagicChair,
        VictorianChair
    }

    public Chair createChair(ChairType type){
        Chair chair;
        switch (type){
            case MultifunctionalChair:
                chair = new MultifunctionalChair();
                break;
            case MagicChair:
                chair = new MagicChair();
                break;
            case VictorianChair:
                chair = new VictorianChair();
                break;
            default:
                chair = null;
                break;
        }
        return chair;
    }

}
