package collections;

import java.util.ListIterator;

public interface List<T> extends Collection<T>, Iterable<T> {


    void addLast(T element);
    void addFirst(T element);
    void addAt(int index, T element);

    T removeLast();
    T removeFirst();
    T removeAt(int index);
    //T removeElement(T element);

    void clear();
    int getSize();
    T[] toArray();
    boolean contains(T element);

    T get(int index);
    T getFirst();
    T getLast();

    ListIterator<T> getListIterator(int startingIndex);
    ListIterator<T> getListIterator();

}
