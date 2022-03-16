package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public abstract class AbstractArrayList<T> implements List<T> {

    private static final int DEFAULT_ARRAY_SIZE = 10;

    protected int size;
    protected T[] internalArray;

    @SuppressWarnings("unchecked")
    protected AbstractArrayList() {
        size = 0;
        internalArray = (T[])new Object[DEFAULT_ARRAY_SIZE];
    }

    protected AbstractArrayList(T[] internalArray) {
        size = internalArray.length;
        this.internalArray = internalArray;
    }

    @SuppressWarnings("unchecked")
    protected AbstractArrayList(int initialCapacity) {
        size = 0;
        internalArray = (T[])new Object[initialCapacity];
    }

    @Override
    public void addLast(T element) {
        if(size == internalArray.length) {
            allocateMemory();
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
            allocateMemory();
        if (size >= 0) System.arraycopy(internalArray, 0, internalArray, 1, size);
        internalArray[0] = element;
        size++;
    }
    // 1 2 3
    // 0 1 2 3

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
            allocateMemory();
        if (size - index >= 0) System.arraycopy(internalArray, index, internalArray, index + 1, size - index);
        internalArray[index] = element;
        size++;
    }

    @Override
    public T removeLast() {
        T element = internalArray[size - 1];
        internalArray[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public T removeFirst() {
        T data = internalArray[0];
        if (size >= 0) System.arraycopy(internalArray, 1, internalArray, 0, size);
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        return internalArray[0];
    }
    @Override
    public T getLast() {
        if(size == 0) getFirst();
        return internalArray[size - 1];
    }
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        if(index == 0) return getFirst();
        if(index == size - 1) return getLast();
        return internalArray[index];
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
    public T[] toArray() {
        return Arrays.copyOf(internalArray, internalArray.length);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.hashCode(internalArray);
        return result;
    }

    @Override
    public boolean contains(T element) {
        for (T t : internalArray) {
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
        size = 0;
    }

    public void deepClear() {
        clear();
        internalArray = Arrays.copyOf(internalArray, DEFAULT_ARRAY_SIZE);
    }

    protected abstract void allocateMemory();

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return internalArray[index++];
            }
        };
    }

}
