package com.ltsllc.commons.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that provides generally useful methods.
 * <P>
 *     The name of the class name was used because Intellij IDEA didn't like the name Utils for some reason.
 * </P>
 *
 */
public class UtilsClass {
    public static <E> List<E> toList(E[] items) {
        List<E> list = new ArrayList<>();

        for (E item : items) {
            list.add(item);
        }

        return list;
    }

}
