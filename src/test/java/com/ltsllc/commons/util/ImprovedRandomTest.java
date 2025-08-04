package com.ltsllc.commons.util;

import org.junit.jupiter.api.Test;

public class ImprovedRandomTest {
    @Test
    public void choose () {
        ImprovedRandom improvedRandom = new ImprovedRandom();
        Integer[] candidates = { 0,1,2,3};
        Integer i = improvedRandom.choose(Integer.class, candidates);

        assert(i == 0 || i == 1 || i == 2 || i == 3);
    }
}
