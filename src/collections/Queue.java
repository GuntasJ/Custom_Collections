package collections;

public interface Queue<T> extends Collection<T>, Iterable<T> {

    /**
     * Adds an element to the end of the queue
     * @param element - Element to add to the queue
     */
    void addLast(T element);

    /**
     * Deletes the first element in the queue
     * @return data of deleted element in queue
     */
    T removeFirst();

    /**
     * Returns the first element in the queue. Will return null if queue is empty.
     * @return data of first element in queue
     */
    T getFirst();

}
