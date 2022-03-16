package collections;

public interface Collection<T> {

    int getSize();
    T[] toArray();
    boolean contains(T element);
    void clear();

    default boolean isEmpty() {
        return getSize() == 0;
    }


}
