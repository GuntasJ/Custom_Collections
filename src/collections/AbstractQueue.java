package collections;

public abstract class AbstractQueue<T> implements Queue<T> {

    protected int size;

    protected AbstractQueue() {
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public abstract void addLast(T element);

    public abstract T removeFirst();

    public abstract T getFirst();

}
