package com.ltsllc.commons.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/******************************************************************************
 * A class that returns its items in a random order.
 *
 * @see ImprovedRandom
 */
public class Bag<E> {
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

    public void add (E item) {
        components.add(item);
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

    public boolean contains(E c) {
        return components.contains(c);
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

    public boolean isEmpty() {
        return components.isEmpty();
    }

}
