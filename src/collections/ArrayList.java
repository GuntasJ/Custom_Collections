package collections;

import java.util.Arrays;

public class ArrayList<T> extends AbstractArrayList<T> {

    private static final double MEMORY_GROWTH_FACTOR = 1.5;
    private static final double MEMORY_SHRINKAGE_FACTOR = 0.5;

    public ArrayList() {
        super();
    }

    public ArrayList(Object[] internalArray) {
        super(internalArray);
    }

    public ArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected void allocateMoreMemory() {
        internalArray = Arrays.copyOf(internalArray, (int) (internalArray.length * MEMORY_GROWTH_FACTOR));
    }

    @Override
    protected void allocateLessMemory() {
        if(size <= internalArray.length * MEMORY_SHRINKAGE_FACTOR)
            internalArray = Arrays.copyOf(internalArray, (int) (internalArray.length * MEMORY_SHRINKAGE_FACTOR));
    }
}
