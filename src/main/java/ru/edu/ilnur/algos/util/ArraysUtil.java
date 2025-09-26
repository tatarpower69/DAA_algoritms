package org.example.util;

import java.util.Arrays;
import java.util.Random;

public class ArraysUtil {

    private static final Random RANDOM = new Random();

    public static int[] randomIntArray(int size, int bound) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = RANDOM.nextInt(bound);
        }
        return arr;
    }

    public static int[] copy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
