package collections;

public interface Deque<T> extends Queue<T> {

    /**
     * Adds an element to the end of the queue
     * @param element - Element to add to the queue
     */
    void addLast(T element);

    void addFirst(T element);

    /**
     * Deletes the first element in the queue
     * @return data of deleted element in queue
     */
    T removeFirst();

    T removeLast();

    /**
     * Returns the first element in the queue. Will return null if queue is empty.
     * @return data of first element in queue
     */
    T getFirst();

    T getLast();



}
