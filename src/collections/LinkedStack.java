package collections;

import java.util.Iterator;
import java.util.ListIterator;

public class LinkedStack<T> extends AbstractStack<T> {

    private Node<T> headNode;

    public LinkedStack() {
        super();
        headNode = null;
    }

    @Override
    public void addFirst(T element) {
        if(isEmpty()) {
            headNode = new Node<>(element);
            size++;
            return;
        }
        Node<T> prependingNode = new Node<>(element);
        prependingNode.nextNode = headNode;
        headNode = prependingNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) return null;
        T data = headNode.data;
        headNode = headNode.nextNode;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        return headNode.data;
    }

    /**
     * This method should not be used. It is not working as of right now.
     *
     * @return the collection as an array.
     */
    @Override
    public T[] toArray() {
        return null;
    }

    /**
     * Uses a linear search to see if an object is present in the collection.
     *
     * @param element the object that you are trying to search for in the collection.
     * @return true if the object is in the collection. False if else.
     */
    @Override
    public boolean contains(T element) {
        if(isEmpty()) return false;
        if(headNode.data.equals(element)) return true;

        for(T t : this) {
            if(t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the collection to have all null values.
     */
    @Override
    public void clear() {
        headNode = null;
        size = 0;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "Stack is empty";
        }
        var stringBuilder = new StringBuilder();
        var stackIterator = iterator();
        for(int i = 0; i < size - 1; i++) {
            stringBuilder.append(stackIterator.next()).append(" <- ");
        }
        return stringBuilder.append(stackIterator.next()).toString();
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
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
