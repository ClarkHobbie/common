package com.ltsllc.commons.util;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A class that improves on {@link java.util.Arrays}.
 */
public class ImprovedArrays {
    public static <T> T[] restOf (Class<T> type, T[] original, int start, int length) {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) Array.newInstance(type, length);
        Arrays.copyOfRange(original, start, original.length - start);
        return newArray;
    }

    public static int[] restOf(int[] original, int length, int start) {
        return Arrays.copyOfRange(original, start, original.length);
    }
}
