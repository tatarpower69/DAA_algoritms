package org.example.select;

import org.example.util.Metrics;
import java.util.Arrays;

public class DeterministicSelect {

    private final Metrics metrics;

    public DeterministicSelect(Metrics metrics) {
        this.metrics = metrics;
    }

    public int select(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Array is empty");
        if (k < 0 || k >= arr.length)
            throw new ArrayIndexOutOfBoundsException("k is out of bounds");
        long start = System.nanoTime();
        int result = selectRecursive(arr, 0, arr.length - 1, k);
        metrics.setExecutionTime(System.nanoTime() - start);
        return result;
    }

    private int selectRecursive(int[] arr, int left, int right, int k) {
        metrics.enterRecursion();
        try {
            while (true) {
                if (left == right) return arr[left];

                int pivotIndex = medianOfMedians(arr, left, right);
                pivotIndex = partition(arr, left, right, pivotIndex);

                int leftSize = pivotIndex - left;
                int rightSize = right - pivotIndex;

                if (k == pivotIndex) return arr[k];
                else if (k < pivotIndex) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
        } finally {
            metrics.exitRecursion();
        }
    }

    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            metrics.incComparisons();
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            Arrays.sort(arr, left, right + 1);
            return left + n / 2;
        }

        int numMedians = (int) Math.ceil(n / 5.0);
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(arr, subLeft, subRight + 1);
            swap(arr, left + i, subLeft + (subRight - subLeft) / 2);
        }
        return medianOfMedians(arr, left, left + numMedians - 1);
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            metrics.incSwaps();
        }
    }
}
