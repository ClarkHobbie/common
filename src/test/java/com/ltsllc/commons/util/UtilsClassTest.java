package com.ltsllc.commons.util;

import com.ltsllc.commons.test.TestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

class UtilsClassTest extends TestCase {

    @Test
    void  toListTest() {
        String[] strings = {
                "one",
                "two",
                "three"
        };

        List<String> list = UtilsClass.toList(strings);

        assert (list.get(0).equalsIgnoreCase("one"));
    }
}