package com.ltsllc.commons.util;

import org.junit.jupiter.api.Test;

class ImprovedArraysTest {

    @Test
    void restOf() {
        int[] original = { 1, 2, 3, 4 };
        int[] copy = ImprovedArrays.restOf(original, 2);

        assert (copy.length == 2);
        assert (copy[0] == 3);
        assert (copy[1] == 4);
    }
}