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

    protected AbstractLinkedList(Object[] array) {
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

    @SuppressWarnings("unchecked")
    protected void makeCopyFromArray(Object[] array) {
        for(Object t : array) {
            addLast((T)t);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(T t : this) {
            array[i++] = t;
        }
        return (T[])array;
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
    public void clear() {
        headNode = null;
        tailNode = null;
        size = 0;
    }

    public abstract T get(int index);

    public abstract void addLast(T element);

    public abstract void addFirst(T element);

    public abstract void addAt(int index, T element);

    public abstract T removeLast();

    public abstract T removeFirst();

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
