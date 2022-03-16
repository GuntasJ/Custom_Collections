package collections;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;

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
        if(isEmpty()) {
            addFirst(element);
            return;
        }
        Node<T> appendingNode = new Node<>(element);
        tailNode.nextNode = appendingNode;
        appendingNode.previousNode = tailNode;
        tailNode = tailNode.nextNode;
        size++;
    }

    @Override
    public void addFirst(T element) {
        if(isEmpty()) {
            headNode = new Node<>(element);
            tailNode = headNode;
            size++;
            return;
        }
        Node<T> prependingNode = new Node<>(element);
        headNode.previousNode = prependingNode;
        prependingNode.nextNode = headNode;
        headNode = headNode.previousNode;
        size++;
    }

    @Override
    public void addAt(int index, T element) {
        Objects.checkIndex(index, size);
        if(index == 0) {
            addFirst(element);
            return;
        }
        if(index == size - 1) {
            addLast(element);
            return;
        }
        Node<T> addingNode = new Node<>(element);
        Node<T> currentNode;
        int halfwayPoint = size / 2;
        if(index <= halfwayPoint) {
            currentNode = headNode;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.nextNode;
            }
            addingNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.previousNode = addingNode;
            currentNode.nextNode = addingNode;
            addingNode.previousNode = currentNode;
        }
        if(index > halfwayPoint) {

        }
        size++;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) return null;
        if(size == 1) {
            T data = headNode.data;
            headNode = null;
            tailNode = null;
            size--;
            return data;
        }
        T data = tailNode.data;
        tailNode = tailNode.previousNode;
        tailNode.nextNode = null;
        size--;
        return data;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) return null;
        if(size == 1) return removeLast();
        T data = headNode.data;
        headNode = headNode.nextNode;
        headNode.previousNode = null;
        size--;
        return data;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "LinkedList is empty";
        }
        var stringBuilder = new StringBuilder();
        var linkedListIterator = iterator();
        for(int i = 0; i < size - 1; i++) {
            stringBuilder.append(linkedListIterator.next()).append(" <=> ");
        }
        return stringBuilder.append(linkedListIterator.next()).toString();
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
            return index < size;
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
