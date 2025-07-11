package com.ltsllc.commons.util;

import java.util.ArrayList;
import java.util.List;

public class UtilsClass {
    public static <E> List<E> toList(E[] items) {
        List<E> list = new ArrayList<>();

        for (E item : items) {
            list.add(item);
        }

        return list;
    }

}
