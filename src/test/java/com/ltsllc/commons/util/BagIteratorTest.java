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
        assert (bag.isEmpty());
    }

    @Test
    void hasNext() {
        Bag<Character> bag = new Bag<Character>();
        Iterator<Character> iterator = bag.iterator();
        assert (!iterator.hasNext());
        bag.add (new Character('a'));
        assert (iterator.hasNext());
    }
}