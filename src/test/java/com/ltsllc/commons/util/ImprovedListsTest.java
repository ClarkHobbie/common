package com.ltsllc.commons.util;

import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImprovedListsTest {

    private class StringEnumeration implements Enumeration<String> {
        protected String[] elements = null;
        protected int position = 0;

        public StringEnumeration (String[] elements) {
            this.elements = elements;
        }

        @Override
        public boolean hasMoreElements() {
            return position < elements.length;
        }

        @Override
        public String nextElement() {
            return elements[position++];
        }
    }

    @Test
    void toList() {
        String[] elements = {"a", "b", "c" };
        StringEnumeration  enumeration = new StringEnumeration(elements);
        List<String> list = ImprovedLists.toList(enumeration);

        assert (list.size() > 0);
    }
}