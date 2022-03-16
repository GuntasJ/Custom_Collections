package collections;

import java.util.Iterator;
import java.util.ListIterator;

public class DoublyLinkedList<T> extends AbstractLinkedList<T> {

    public DoublyLinkedList() {
        super();
    }
    public DoublyLinkedList(Object[] array) {
        super(array);
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void addLast(T element) {

    }

    @Override
    public void addFirst(T element) {

    }

    @Override
    public void addAt(int index, T element) {

    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    public ListIterator<T> getListIterator(int startingIndex) {
        return new DoublyLinkedListIterator(startingIndex);
    }

    private class DoublyLinkedListIterator implements ListIterator<T> {

        private int index;

        public DoublyLinkedListIterator() {
            this(0);
        }

        public DoublyLinkedListIterator(int startingIndex) {
            index = startingIndex;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

}
