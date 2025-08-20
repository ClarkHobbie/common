package com.ltsllc.commons.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * A collection of useful methods when dealing with lists.
 */
public class ImprovedLists {
    /**
     * Convert an {@link Enumeration} to a {@link List}.
     * @param enumeration The enumeration to convert.
     * @return The resulting list.
     * @param <T> The type of the list.
     */
    public static <T> List<T> toList (Enumeration<T> enumeration) {
        List<T> list = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            T t = enumeration.nextElement();
            list.add(t);
        }

        return list;
    }
}