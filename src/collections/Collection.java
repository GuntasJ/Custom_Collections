package collections;

public interface Collection<T> {


    /**
     * @return the size of the collection as an int.
     */
    int getSize();

    /**
     * This method should not be used. It is not working as of right now.
     * @return the collection as an array.
     */
    T[] toArray();


    /**
     * Uses a linear search to see if an object is present in the collection.
     * @param element - the object that you are trying to search for in the collection.
     * @return true if the object is in the collection. False if else.
     */
    boolean contains(T element);

    /**
     * Clears the collection to have all null values.
     */
    void clear();

    /**
     * Checks to see if the container is empty
     * @return True if container is empty, False otherwise
     */
    default boolean isEmpty() {
        return getSize() == 0;
    }


}
