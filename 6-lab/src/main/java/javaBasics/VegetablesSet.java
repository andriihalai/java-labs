package javaBasics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A custom implementation of a {@link Set} for storing unique {@link Vegetable} objects.
 * This class does not allow {@code null} elements and uses an internal array for storage.
 * When the internal array reaches its capacity, it resizes automatically.
 * <p>
 * This implementation supports all standard {@link Set} operations.
 * </p>
 */
public class VegetablesSet implements Set<Vegetable> {
    private Vegetable[] vegetables;
    private int size = 0;
    private final int DEFAULT_ARRAY_LENGTH = 15;

    /**
     * Constructs an empty {@code VegetablesSet} with a default initial capacity.
     */
    public VegetablesSet() {
        this.vegetables = new Vegetable[DEFAULT_ARRAY_LENGTH];
    }

    /**
     * Constructs a {@code VegetablesSet} containing a single {@link Vegetable}.
     *
     * @param vegetable the vegetable to be added to the set.
     * @throws NullPointerException if the provided {@code vegetable} is {@code null}.
     */
    public VegetablesSet(Vegetable vegetable) {
        this();
        if (vegetable == null) {
            throw new NullPointerException("Vegetable cannot be null.");
        }
        this.add(vegetable);
    }

    /**
     * Constructs a {@code VegetablesSet} containing all elements from the specified collection.
     *
     * @param collection the collection whose elements are to be added to the set.
     * @throws NullPointerException if the provided {@code collection} is {@code null}.
     */
    public VegetablesSet(Collection<? extends Vegetable> collection) {
        this();
        if (collection == null) {
            throw new NullPointerException("Collection cannot be null.");
        }
        this.addAll(collection);
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the size of the set.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns {@code true} if this set contains no elements.
     *
     * @return {@code true} if the set is empty, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Checks if the set contains the specified element.
     *
     * @param o the element to check for.
     * @return {@code true} if the set contains the element, {@code false} otherwise.
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Vegetable)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (vegetables[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an {@link Iterator} for the elements in the set.
     */
    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Vegetable next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return vegetables[currentIndex++];
            }
        };
    }

    /**
     * Returns an array containing all elements in this set.
     *
     * @return an array containing all elements in the set.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(vegetables, size);
    }

    /**
     * Returns an array containing all elements in this set; the runtime type of the returned
     * array is that of the specified array.
     *
     * @param a the array into which the elements of the set are to be stored.
     * @return an array containing all elements in the set.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(vegetables, size, a.getClass());
        }
        System.arraycopy(vegetables, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Adds the specified vegetable to this set if it is not already present.
     *
     * @param vegetable the vegetable to add.
     * @return {@code true} if the vegetable was added, {@code false} otherwise.
     * @throws NullPointerException if the provided vegetable is {@code null}.
     */
    @Override
    public boolean add(Vegetable vegetable) {
        if (vegetable == null) {
            throw new NullPointerException("VegetablesSet does not allow null elements.");
        }
        if (contains(vegetable)) {
            return false;
        }
        if (size == vegetables.length) {
            vegetables = Arrays.copyOf(vegetables, (int) Math.floor(size * 1.3));
        }
        vegetables[size++] = vegetable;
        return true;
    }

    /**
     * Removes the specified element from this set, if it is present.
     *
     * @param o the element to remove.
     * @return {@code true} if the element was removed, {@code false} otherwise.
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Vegetable)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (vegetables[i].equals(o)) {
                System.arraycopy(vegetables, i + 1, vegetables, i, size - i - 1);
                vegetables[--size] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this set contains all elements of the specified collection.
     *
     * @param c the collection to check.
     * @return {@code true} if all elements are present, {@code false} otherwise.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements from the specified collection to this set.
     *
     * @param c the collection containing elements to add.
     * @return {@code true} if this set was modified, {@code false} otherwise.
     */
    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        boolean modified = false;
        for (Vegetable vegetable : c) {
            if (add(vegetable)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     *
     * @param c the collection containing elements to retain.
     * @return {@code true} if this set was modified, {@code false} otherwise.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(vegetables[i])) {
                remove(vegetables[i]);
                i--;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements in the specified collection from this set.
     *
     * @param c the collection containing elements to remove.
     * @return {@code true} if this set was modified, {@code false} otherwise.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object item : c) {
            if (remove(item)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements from this set, leaving it empty.
     */
    @Override
    public void clear() {
        Arrays.fill(vegetables, 0, size, null);
        size = 0;
    }
}
