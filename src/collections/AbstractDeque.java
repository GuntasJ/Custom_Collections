package collections;

public abstract class AbstractDeque<T> implements Deque<T> {

    protected int size;

    protected AbstractDeque() {
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * Adds an element to the end of the queue
     * @param element - Element to add to the queue
     */
    public abstract void addLast(T element);

    public abstract void addFirst(T element);

    /**
     * Deletes the first element in the queue
     * @return data of deleted element in queue
     */
    public abstract T removeFirst();

    public abstract T removeLast();

    /**
     * Returns the first element in the queue. Will return null if queue is empty.
     * @return data of first element in queue
     */
    public abstract T getFirst();

    public abstract T getLast();

}
