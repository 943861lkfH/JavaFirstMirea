package ru.mirea.task14;
import java.util.*;

public class Players {
    private Stack <Integer> currentCards;
    private Stack <Integer> wonCards = new Stack<>();
    private Queue<Integer> queue;
    private Deque<Integer> deque;
    private String name;
    private int count;
    public Players(String name, Stack <Integer> cards){
        this.currentCards = cards;
        this.name = name;
    }
    public void updateCardsStack(){
        while(!this.wonCards.empty())
        {
            this.currentCards.push(this.wonCards.pop());
        }
    }
    public boolean checkCardsStack(){
        while(this.currentCards.empty())
        {
            if(this.wonCards.empty())
                return false;
            this.updateCardsStack();
        }
        return true;
    }
    public void addCardsStack(int card1, int card2){
        this.wonCards.push(card1);
        this.wonCards.push(card2);
    }
    public Players cardGameStack(Players first, Players second){
        int card1, card2, count = 0;
        while(true) {
            if(count>=106) {
                System.out.println("botva");
                return null;
            }
            count ++;
            card1 = first.currentCards.pop();
            card2 = second.currentCards.pop();
            if (card1 > card2) {
                if (card1 == 9 && card2 == 0)
                    second.addCardsStack(card1, card2);
                else
                    first.addCardsStack(card1, card2);
            } else {
                if (card1 == 0 && card2 == 9)
                    first.addCardsStack(card1, card2);
                else
                    second.addCardsStack(card1, card2);
            }
            if(!first.checkCardsStack()){
                second.count = count;
                return second;
            }
            if(!second.checkCardsStack()){
                first.count = count;
                return first;
            }
        }

    }
    public void startGameStack(Players first, Players second){
        Players player = cardGameStack(first, second);
        if(player!=null)
            System.out.println(player.name + "  " + player.count);
    }

    public Players(String name, Queue <Integer> queue){
        this.queue = queue;
        this.name = name;
    }
    public void addCardsQueue(int card1, int card2){
        this.queue.offer(card1);
        this.queue.offer(card2);
    }
    public Players cardGameQueue(Players first, Players second){
        int card1, card2, count = 0;
        while(true) {
            if(count>=106) {
                System.out.println("botva");
                return null;
            }
            count ++;
            card1 = first.queue.poll();
            card2 = second.queue.poll();
            if (card1 > card2) {
                if (card1 == 9 && card2 == 0)
                    second.addCardsQueue(card1, card2);
                else
                    first.addCardsQueue(card1, card2);
            } else {
                if (card1 == 0 && card2 == 9)
                    first.addCardsQueue(card1, card2);
                else
                    second.addCardsQueue(card1, card2);
            }
            if(first.queue.isEmpty()){
                second.count = count;
                return second;
            }
            if(second.queue.isEmpty()){
                first.count = count;
                return first;
            }
        }

    }
    public void startGameQueue(Players first, Players second){
        Players player = cardGameQueue(first, second);
        if(player!=null)
            System.out.println(player.name + "  " + player.count);
    }

    public Players(String name, Deque <Integer> deque){
        this.deque = deque;
        this.name = name;
    }
    public void addCardsDeque(int card1, int card2){
        this.deque.addLast(card1);
        this.deque.addLast(card2);
    }
    public Players cardGameDeque(Players first, Players second){
        int card1, card2, count = 0;
        while(true) {
            if(count>=106) {
                System.out.println("botva");
                return null;
            }
            count ++;
            card1 = first.deque.pop();
            card2 = second.deque.pop();
            if (card1 > card2) {
                if (card1 == 9 && card2 == 0)
                    second.addCardsDeque(card1, card2);
                else
                    first.addCardsDeque(card1, card2);
            } else {
                if (card1 == 0 && card2 == 9)
                    first.addCardsDeque(card1, card2);
                else
                    second.addCardsDeque(card1, card2);
            }
            if(first.deque.isEmpty()){
                second.count = count;
                return second;
            }
            if(second.deque.isEmpty()){
                first.count = count;
                return first;
            }
        }

    }
    public void startGameDeque(Players first, Players second){
        Players player = cardGameDeque(first, second);
        if(player!=null)
            System.out.println(player.name + "  " + player.count);
    }
}
