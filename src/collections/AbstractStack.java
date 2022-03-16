package collections;

public abstract class AbstractStack<T> implements Stack<T> {

    protected int size;

    protected AbstractStack() {
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public abstract void addFirst(T element);

    public abstract T removeFirst();

    public abstract T getFirst();


}
