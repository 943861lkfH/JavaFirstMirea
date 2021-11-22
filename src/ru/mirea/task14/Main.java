package ru.mirea.task14;
import java.util.*;

public class Main {
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
        int array[] = new int[5];
        for(int i = 0; i < 5; i++) {
            Scanner in = new Scanner(System.in);
            array[i] = in.nextInt();
        }
        for(int i = 4; i >= 0; i--)
            queue.offer(array[i]);
        return queue;
    }
    public static Deque <Integer> inputDeque(){
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < 5; i++) {
            Scanner in = new Scanner(System.in);
            deque.addFirst(in.nextInt());
        }
        return deque;
    }
    public static void main(String[] args) {
        //With Stack
        Players first = new Players("first", inputStack());
        Players second = new Players("second", inputStack());
        System.out.println("With Stack: ");
        first.startGameStack(first, second);

        //With Queue
        first = new Players("first", inputQueue());
        second = new Players("second", inputQueue());
        System.out.println("With Queue: ");
        first.startGameQueue(first,second);

        //With Deque
        first = new Players("first", inputDeque());
        second = new Players("second", inputDeque());
        System.out.println("With Deque: ");
        first.startGameDeque(first,second);
    }
}