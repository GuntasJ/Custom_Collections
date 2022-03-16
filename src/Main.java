import collections.ArrayList;
import collections.Deque;
import collections.LinkedDeque;
import collections.LinkedStack;
import collections.Queue;
import collections.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {

        Deque<Integer> integerDeque = new LinkedDeque<>();

        for(int i = 0; i < 20; i++) {
            integerDeque.addLast(i);
        }

        System.out.println(integerDeque);


    }


}
