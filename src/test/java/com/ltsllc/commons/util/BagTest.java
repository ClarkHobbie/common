package com.ltsllc.commons.util;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

class BagTest {

    @Test
    void add() {
        Bag<Character> bag = new Bag<Character>();
        bag.add('C');

        assert (bag.contains('C'));
    }

    @Test
    void next() {
        Bag<Character> bag = new Bag<>();
        bag.add(new Character('a'));
        bag.add(new Character('b'));

        assert(bag.size() >= 2);
        Character c = bag.next();
        assert (c != null);
        assert(bag.notEmpty());
        c = bag.next();
        assert (c != null);
        assert (bag.isEmpty());

    }

    @Test
    void notEmpty() {
        Bag<Character> bag = new Bag<>();
        assert (!bag.notEmpty());
        bag.add(new Character('a'));
        assert (bag.notEmpty());
    }

    @Test
    void iterator() {
        Bag<Character> bag = new Bag<>();
        Iterator<Character> i = bag.iterator();
        assert(i != null);
    }
}