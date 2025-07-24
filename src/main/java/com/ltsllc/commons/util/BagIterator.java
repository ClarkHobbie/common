package com.ltsllc.commons.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An {@link Iterator} for a bag.
 *
 * The items in the bag are returned by {@link #next()} are in a random order.
 * <P>
 *     Once a {@link BagIterator} is created, it leads a separate life from its instance of {@link Bag}: changing
 *     the bag does not change the bagIterator.
 * </P>
 *
 * @param <T> The type of the items.
 */
public class BagIterator<T> implements Iterator<T> {
    protected List<T> list = null;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public BagIterator (Bag<T> bag) {
        this.list = new ArrayList<>(bag.getComponents());
    }

    @Override
    public T next() {
        SecureRandom random = new SecureRandom();
        int index = random.nextInt(list.size());
        return list.remove(index);
    }

    @Override
    public boolean hasNext () {
        return !list.isEmpty();
    }
}
