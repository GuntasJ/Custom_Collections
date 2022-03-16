package collections;

import java.util.Arrays;

public class ArrayList<T> extends AbstractArrayList<T> {

    private static final double MEMORY_GROWTH_FACTOR = 1.5;

    public ArrayList() {
        super();
    }

    public ArrayList(T[] internalArray) {
        super(internalArray);
    }

    public ArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected void allocateMemory() {
        internalArray = Arrays.copyOf(internalArray, (int) (internalArray.length * MEMORY_GROWTH_FACTOR));
    }
}
