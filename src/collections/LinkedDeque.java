package collections;

import java.util.Iterator;

public class LinkedDeque<T> extends AbstractDeque<T> {

    private Node<T> headNode;
    private Node<T> tailNode;

    public LinkedDeque() {
        super();
        headNode = null;
        tailNode = null;
    }


    @Override
    public void addLast(T element) {
        if(isEmpty()) {
            headNode = new Node<>(element);
            tailNode = headNode;
            size++;
            return;
        }
        Node<T> appendingNode = new Node<>(element);
        tailNode.nextNode = appendingNode;
        appendingNode.previousNode = tailNode;
        tailNode = appendingNode;
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
        prependingNode.nextNode = headNode;
        headNode.previousNode = prependingNode;
        headNode = prependingNode;
        size++;
    }


    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        if(size == 1) {
            T data = headNode.data;
            headNode = null;
            tailNode = null;
            size--;
            return data;
        }
        T data = headNode.data;
        headNode = headNode.nextNode;
        headNode.previousNode = null;
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        if(size == 1) {
            return removeFirst();
        }
        T data = tailNode.data;
        tailNode = tailNode.previousNode;
        tailNode.nextNode = null;
        size--;
        return data;
    }


    @Override
    public T getFirst() {
        return headNode.data;
    }

    @Override
    public T getLast() {
        return tailNode.data;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean contains(T element) {
        if(isEmpty()) return false;
        if(tailNode.data.equals(element) || headNode.data.equals(element)) return true;
        for(T t : this) {
            if(t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        headNode = null;
        tailNode = null;
        size = 0;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "Queue is empty";
        }
        var stringBuilder = new StringBuilder();
        var queueIterator = iterator();
        for(int i = 0; i < size - 1; i++) {
            stringBuilder.append(queueIterator.next()).append(" <=> ");
        }
        return stringBuilder.append(queueIterator.next()).toString();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            Node<T> currentNode = headNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.nextNode;
                return data;
            }
        };
    }
}
