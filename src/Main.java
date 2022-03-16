import collections.ArrayList;
import collections.List;
import collections.SinglyLinkedList;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i < 12; i++) {
            arrayList.addLast(i);
        }
        System.out.println(arrayList);

        arrayList.addFirst(-10);
        System.out.println(arrayList);

    }



}
