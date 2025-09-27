package org.example.sort;

import org.example.util.Metrics;
import java.util.Random;

public class QuickSort {

    private static final Random random = new Random();

    public static void sort(int[] arr, Metrics metrics) {
        quickSort(arr, 0, arr.length - 1, metrics);
    }

    private static void quickSort(int[] arr, int low, int high, Metrics metrics) {
        while (low < high) {
            metrics.enterRecursion();
            try {
                int pivotIndex = partition(arr, low, high, metrics);
                if (pivotIndex - low < high - pivotIndex) {
                    quickSort(arr, low, pivotIndex - 1, metrics);
                    low = pivotIndex + 1;
                } else {
                    quickSort(arr, pivotIndex + 1, high, metrics);
                    high = pivotIndex - 1;
                }
            } finally {
                metrics.exitRecursion();
            }
        }
    }

    private static int partition(int[] arr, int low, int high, Metrics metrics) {
        int pivotIndex = low + random.nextInt(high - low + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high, metrics);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            metrics.incComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j, metrics);
            }
        }
        swap(arr, i + 1, high, metrics);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            metrics.incSwaps();
        }
    }
}
