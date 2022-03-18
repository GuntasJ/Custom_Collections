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
        Node<T> currentNode;
        if(index <= size) {
            currentNode = headNode;
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
        }
        else {
            currentNode = tailNode;
            for(int i = 0; i < size - index; i++) {
                currentNode = currentNode.previousNode;
            }
        }
        return currentNode.data;


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
            currentNode = tailNode;
            for(int i = 0; i < size - index - 1; i++) {
                currentNode = currentNode.previousNode;
            }
            addingNode.previousNode = currentNode.previousNode;
            currentNode.previousNode.nextNode = addingNode;
            currentNode.previousNode = addingNode;
            addingNode.nextNode = currentNode;
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
    public T removeAt(int index) {
        if(index == 0) return removeFirst();
        if(index == size - 1) return removeLast();

        Node<T> currentNode = getNodeAt(index);
        T data = currentNode.data;
        currentNode.previousNode.nextNode = currentNode.nextNode;
        currentNode.nextNode.previousNode = currentNode.previousNode;
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

    @Override
    protected Node<T> getNodeAt(int index) {
        Node<T> currentNode;
        if(index <= size) {
            currentNode = headNode;
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
        }
        else {
            currentNode = tailNode;
            for(int i = 0; i < size - index; i++) {
                currentNode = currentNode.previousNode;
            }
        }
        return currentNode;
    }


    @Override
    public ListIterator<T> getListIterator() {
        return getListIterator(0);
    }

    @Override
    public ListIterator<T> getListIterator(int startingIndex) {
        Objects.checkIndex(startingIndex, size);
        return new DoublyLinkedListIterator(startingIndex);
    }

    private class DoublyLinkedListIterator implements ListIterator<T> {

        private int index;
        private Node<T> currentNode;

        public DoublyLinkedListIterator(int startingIndex) {
            index = startingIndex;
            currentNode = getNodeAt(index);
        }



        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T data = currentNode.data;
            index++;
            currentNode = currentNode.nextNode;
            return data;
        }

        @Override
        public boolean hasPrevious() {
            return index > -1;
        }

        @Override
        public T previous() {
            T data = currentNode.data;
            index--;
            currentNode = currentNode.previousNode;
            return data;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
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
