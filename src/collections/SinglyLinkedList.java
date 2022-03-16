package collections;

import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedList<T> extends AbstractLinkedList<T> {

    public SinglyLinkedList() {
        super();
    }
    public SinglyLinkedList(T[] array) {
        super(array);
    }

    @Override
    protected void makeCopyFromArray(T[] array) {
        for(T element: array) {
            addLast(element);
        }
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        var linkedListIterator = iterator();
        for(int i = 0; i < index; i++) {
            linkedListIterator.next();
        }
        return linkedListIterator.next();
    }

    @Override
    public void addLast(T element) {
        if(isEmpty()) {
            addFirst(element);
        }
        else {
            tailNode.nextNode = new Node<>(element);
            tailNode = tailNode.nextNode;
            size++;
        }
    }

    @Override
    public void addFirst(T element) {
        if(isEmpty()) {
            headNode = new Node<>(element);
            tailNode = headNode;
        }
        else {
            Node<T> prependingNode = new Node<>(element);
            prependingNode.nextNode = headNode;
            headNode = prependingNode;
        }
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
        Node<T> currentNode = headNode;
        for(int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }
        Node<T> addingNode = new Node<>(element);
        addingNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = addingNode;
        size++;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public void clear() {
        headNode = null;
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[])new Object[size];
        int i = 0;
        for (T element : this) {
            array[i++] = element;
        }
        return array;
    }

    @Override
    public boolean contains(T element) {
        if(isEmpty()) return false;
        if(headNode.data.equals(element) || tailNode.data.equals(element)) return true;

        for (T t : this) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "LinkedList is empty";
        }
        var stringBuilder = new StringBuilder();
        var linkedListIterator = iterator();
        for(int i = 0; i < size - 1; i++) {
            stringBuilder.append(linkedListIterator.next()).append(" -> ");
        }
        return stringBuilder.append(linkedListIterator.next()).toString();
    }
}
