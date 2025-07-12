package com.ltsllc.commons.util;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

class BagIteratorTest {

    @Test
    void next() {
        Bag<Character> bag = new Bag<Character>();
        bag.add(new Character('a'));
        assert (bag.notEmpty());
        Iterator<Character> iter = bag.iterator();
        assert (iter.hasNext());
        Character candidate = iter.next();
        assert (candidate != null);
        BagIterator bagIterator = (BagIterator) iter;
        assert (bagIterator.getList().isEmpty());
    }

    @Test
    void hasNext() {
        Bag<Character> bag = new Bag<Character>();
        Iterator<Character> iterator = bag.iterator();
        assert (!iterator.hasNext());
        BagIterator bagIterator = (BagIterator) iterator;
        bagIterator.getList().add(new Character('a'));
        assert (iterator.hasNext());
    }
}