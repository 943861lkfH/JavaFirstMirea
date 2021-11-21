package ru.mirea.task14;
import java.util.*;

public class Players {
    private Stack <Integer> currentCards;
    private Stack <Integer> wonCards = new Stack<>();
    private String name;
    private int count;
    public Players(String name, Stack <Integer> cards){
        this.currentCards = cards;
        this.name = name;
    }
    public void updateCards(){
        while(!this.wonCards.empty())
        {
            this.currentCards.push(this.wonCards.pop());
        }
    }
    public boolean checkCards(){
        while(this.currentCards.empty())
        {
            if(this.wonCards.empty())
                return false;
            this.updateCards();
        }
        return true;
    }
    public void addCards(int card1, int card2){
        this.wonCards.push(card2);
        this.wonCards.push(card1);
    }
    public Players cardGame(Players first, Players second){
        int card1, card2, count = 0;
        while(true) {
            count ++;
            card1 = first.currentCards.pop();
            card2 = second.currentCards.pop();
            if (card1 > card2) {
                if (card1 == 9 && card2 == 0)
                    second.addCards(card1, card2);
                else
                    first.addCards(card1, card2);
            } else {
                if (card1 == 0 && card2 == 9)
                    first.addCards(card1, card2);
                else
                    second.addCards(card1, card2);
            }
            if(!first.checkCards()){
                second.count = count;
                return second;
            }
            if(!second.checkCards()){
                first.count = count;
                return first;
            }
        }

    }
    public void startGame(Players first, Players second){
        Players player = cardGame(first, second);
        System.out.println(player.name + "  " + player.count);
    }
}
