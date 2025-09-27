package org.example.sort;

import org.example.util.Metrics;

public class MergeSort {
    private static final int INSERTION_SORT_THRESHOLD = 16;

    public static void sort(int[] arr, Metrics metrics) {
        if (arr == null || arr.length <= 1) return;
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1, metrics);
    }

    private static void mergeSort(int[] arr, int[] aux, int left, int right, Metrics metrics) {
        metrics.enterRecursion();
        try {
            if (right - left + 1 <= INSERTION_SORT_THRESHOLD) {
                insertionSort(arr, left, right, metrics);
                return;
            }
            int mid = (left + right) / 2;
            mergeSort(arr, aux, left, mid, metrics);
            mergeSort(arr, aux, mid + 1, right, metrics);
            merge(arr, aux, left, mid, right, metrics);
        } finally {
            metrics.exitRecursion();
        }
    }

    private static void merge(int[] arr, int[] aux, int left, int mid, int right, Metrics metrics) {
        System.arraycopy(arr, left, aux, left, right - left + 1);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            metrics.incComparisons();
            if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
                metrics.incSwaps();
            }
        }
        while (i <= mid) arr[k++] = aux[i++];
        while (j <= right) arr[k++] = aux[j++];
    }

    private static void insertionSort(int[] arr, int left, int right, Metrics metrics) {
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
