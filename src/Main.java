import collections.DoublyLinkedList;
import collections.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new DoublyLinkedList<>();

        for(int i = 0; i < 10; i++) {
            integerList.addLast(i);
        }

        System.out.println(integerList);

        integerList.addAt(3, -1000);

        System.out.println(integerList);
    }


}
