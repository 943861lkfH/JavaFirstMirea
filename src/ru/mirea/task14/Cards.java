package ru.mirea.task14;
import java.util.*;

public class Cards {
    public static Stack<Integer> inputStack(){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 5; i++) {
            Scanner in = new Scanner(System.in);
            stack.push(in.nextInt());
        }
        return stack;
    }
    public static Queue<Integer> inputQueue(){
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < 5; i++) {
            Scanner in = new Scanner(System.in);
            queue.offer(in.nextInt());
        }
        return queue;
    }
    public static void main(String[] args) {
        Players first = new Players("first", inputStack());
        Players second = new Players("second", inputStack());
        System.out.println("With Stack: ");
        first.startGame(first, second);

    }
}