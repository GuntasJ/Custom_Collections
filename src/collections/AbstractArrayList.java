package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;


public abstract class AbstractArrayList<T> implements List<T> {

    private static final int DEFAULT_ARRAY_SIZE = 10;

    protected int size;
    protected Object[] internalArray;

    protected AbstractArrayList() {
        size = 0;
        internalArray = new Object[DEFAULT_ARRAY_SIZE];
    }

    protected AbstractArrayList(Object[] internalArray) {
        size = internalArray.length;
        this.internalArray = internalArray;
    }


    protected AbstractArrayList(int initialCapacity) {
        size = 0;
        internalArray = new Object[initialCapacity];
    }

    @Override
    public void addLast(T element) {
        if(size == internalArray.length) {
            allocateMoreMemory();
        }
        internalArray[size] = element;
        size++;
    }

    @Override
    public void addFirst(T element) {
        if(isEmpty()) {
            internalArray[0] = element;
            size++;
            return;
        }
        if(size == internalArray.length)
            allocateMoreMemory();
        if (size >= 0) System.arraycopy(internalArray, 0, internalArray, 1, size);
        internalArray[0] = element;
        size++;
    }

    @Override
    public void addAt(int index, T element) {
        Objects.checkIndex(index,size);
        if(index == 0) {
            addFirst(element);
            return;
        }
        if(index == size - 1) {
            addLast(element);
            return;
        }
        if(size == internalArray.length)
            allocateMoreMemory();
        if (size - index >= 0)
            System.arraycopy(internalArray, index, internalArray, index + 1, size - index);
        internalArray[index] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T removeLast() {
        T element = (T)internalArray[size - 1];
        internalArray[size - 1] = null;
        size--;
        allocateLessMemory();
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T removeFirst() {
        T data = (T)internalArray[0];
        if (size >= 0) System.arraycopy(internalArray, 1, internalArray, 0, size);
        size--;
        allocateLessMemory();
        return data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        Objects.checkIndex(0, size);
        T data = (T) internalArray[index];
        if(index == 0) {
            return removeFirst();
        }
        if(index == size - 1) {
            return removeLast();
        }
        return null;

    }

    @Override
    public void removeElement(T element) {
        int index = 0;
        for(int i = 0; i < size; i++) {
            if(internalArray[i].equals(element)) {
                index = i;
                break;
            }
        }
        removeAt(index);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getFirst() {
        return (T)internalArray[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getLast() {
        if(size == 0) getFirst();
        return (T)internalArray[size - 1];
    }
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        if(index == 0) return getFirst();
        if(index == size - 1) return getLast();
        return (T)internalArray[index];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i = 0; i < size - 1; i++) {
            stringBuilder.append(internalArray[i]).append(", ");
        }
        stringBuilder.append(internalArray[size - 1]);
        return stringBuilder.append("]").toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[])Arrays.copyOf(internalArray, internalArray.length);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.hashCode(internalArray);
        return result;
    }

    @Override
    public boolean contains(T element) {
        for (Object t: internalArray) {
            if (t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            internalArray[i] = null;
        }
        internalArray = Arrays.copyOf(internalArray, DEFAULT_ARRAY_SIZE);
        size = 0;
    }


    protected abstract void allocateMoreMemory();

    protected abstract void allocateLessMemory();

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T)internalArray[index++];
            }
        };
    }



}
