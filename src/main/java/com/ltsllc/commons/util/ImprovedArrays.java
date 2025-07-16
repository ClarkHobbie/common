package com.ltsllc.commons.util;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A class that improves on {@link java.util.Arrays}.
 */
public class ImprovedArrays {
    public static <T> T[] restOf (T[] original, int start) {
        return (T[]) Arrays.copyOfRange(original, start, original.length, original.getClass());
    }

    public static int[] restOf(int[] original, int start) {
        return Arrays.copyOfRange(original, start, original.length);
    }
}
