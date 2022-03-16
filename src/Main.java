import collections.ArrayList;
import collections.LinkedQueue;
import collections.List;
import collections.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedQueue<>();

        for(int i = 0; i < 10; i++) {
            integerQueue.addLast(i);
        }


        System.out.println(integerQueue);
        System.out.println(integerQueue.getSize());

        integerQueue.removeFirst();

        System.out.println(integerQueue);
        System.out.println(integerQueue.getSize());
    }
}
