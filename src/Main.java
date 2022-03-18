import collections.DoublyLinkedList;
import collections.List;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new DoublyLinkedList<>();

        for(int i = 0; i < 20; i++) {
            integerList.addLast(i);
        }

        System.out.println(integerList);

        integerList.removeAt(10);

        System.out.println(integerList);

    }


}
