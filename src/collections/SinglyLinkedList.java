package collections;

import java.util.Iterator;
import java.util.Objects;

public class SinglyLinkedList<T> extends AbstractLinkedList<T> {

    public SinglyLinkedList() {
        super();
    }
    public SinglyLinkedList(Object[] array) {
        super(array);
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
        Node<T> currentNode = headNode;
        while(currentNode.nextNode != tailNode) {
            currentNode = currentNode.nextNode;
        }
        T data = tailNode.data;
        currentNode.nextNode = null;
        tailNode = currentNode;
        size--;
        return data;
    }

    @Override
    public T removeFirst() {
        T data = headNode.data;
        headNode = headNode.nextNode;
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
            stringBuilder.append(linkedListIterator.next()).append(" -> ");
        }
        return stringBuilder.append(linkedListIterator.next()).toString();
    }
}
