package ru.edu.ilnur.algos.sort;

import ru.edu.ilnur.algos.util.Metrics;

public class MergeSort {

    public static void sort(int[] arr, Metrics metrics) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1, metrics);
    }

    private static void mergeSort(int[] arr, int left, int right, Metrics metrics) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, metrics);
            mergeSort(arr, mid + 1, right, metrics);
            merge(arr, left, mid, right, metrics);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, Metrics metrics) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            metrics.incComparisons();
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                metrics.incSwaps();
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}
