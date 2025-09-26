package ru.edu.ilnur.algos.sort;

import ru.edu.ilnur.algos.util.Metrics;


public class InsertionSort {
    public static void sort(int[] arr, int left, int right, Metrics metrics) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left) {
                metrics.incComparisons();
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    metrics.incSwaps();
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
    }
}
