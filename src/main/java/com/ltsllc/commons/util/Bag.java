package com.ltsllc.commons.util;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 * A class that returns its items in a random order.
 *
 * @see java.util.Random
 */
public class Bag<E> {
    private static ImprovedRandom random = new ImprovedRandom();

    private List<E> components = new ArrayList<E>();

    public Bag () {
    }

    public void add (E item) {
        components.add(item);
    }

    public E get() {
        int index = random.nextIndex(components.size());
        return components.remove(index);
    }

    public boolean empty () {
        return components.size() <= 0;
    }

}
