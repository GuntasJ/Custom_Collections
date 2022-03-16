import collections.ArrayList;
import collections.LinkedStack;
import collections.Stack;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            integers.addLast(i);
        }

        System.out.println(integers);

        Integer x = integers.get(10);


        System.out.println(x);
    }


}
