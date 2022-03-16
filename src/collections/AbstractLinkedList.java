package collections;

import java.util.Iterator;

public abstract class AbstractLinkedList<T> implements List<T> {

    protected int size;
    protected Node<T> headNode;
    protected Node<T> tailNode;

    protected AbstractLinkedList() {
        headNode = null;
        tailNode = null;
        size = 0;
    }

    protected AbstractLinkedList(T[] array) {
        makeCopyFromArray(array);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T getFirst() {
        return headNode.data;
    }
    @Override
    public T getLast() {
        return tailNode.data;
    }


    protected abstract void makeCopyFromArray(T[] array);

    public abstract T get(int index);

    public abstract void addLast(T element);

    public abstract void addFirst(T element);

    public abstract void addAt(int index, T element);

    public abstract T removeLast();

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

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
