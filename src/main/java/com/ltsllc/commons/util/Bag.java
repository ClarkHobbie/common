package com.ltsllc.commons.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A class that returns its items in a random order.
 *
 * @see ImprovedRandom
 */
public class Bag<E> implements Collection<E> {
    private static ImprovedRandom random = new ImprovedRandom();
    private List<E> components = new ArrayList<E>();

    public Bag () {
    }

    public List<E> getComponents() {
        return components;
    }

    public void setComponents(List<E> components) {
        this.components = new ArrayList<>(components);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * get the next item from the Bag and remove it from the Bag.
     * <p>
     * Note that this method is different from {@link List#get} in that the item returned is no longer contained in the
     * Bag.  Note also that it picks the next item at random.
     *
     * @return The next item.
     */
    public E get() {
        int index = random.nextIndex(components.size());
        return components.remove(index);
    }

    public boolean empty () {
        return components.size() <= 0;
    }

    public int size() {
        return components.size();
    }

    /**
     * This is just a call to {@link #get()}.
     * @return The next item.
     * @see #get
     */
    public E next() {
        return get();
    }

    public boolean notEmpty() {
        return !components.isEmpty();
    }

    public Iterator<E> iterator() {
        return new BagIterator<E>(this);
    }

    @Override
    public Object[] toArray() {
        return components.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return components.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return components.add(e);
    }

    public boolean isEmpty() {
        return components.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return components.contains(o);
    }

    public boolean addAll (Collection collection) {
        return components.addAll(collection);
    }

}
