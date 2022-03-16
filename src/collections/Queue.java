package collections;

public interface Queue<T> extends Collection<T>, Iterable<T> {

    void addLast(T element);

    T removeFirst();

    T getFirst();

}
