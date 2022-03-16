package collections;

public interface Stack<T> extends Collection<T>, Iterable<T> {

    void addFirst(T element);

    T removeFirst();

    T getFirst();

}
