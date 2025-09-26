package ru.edu.ilnur.algos.util;

public class Metrics {
    private long comparisons;
    private long swaps;
    private long recursionDepth;
    private long maxRecursionDepth;

    public void incComparisons() {
        comparisons++;
    }

    public void incSwaps() {
        swaps++;
    }

    public void enterRecursion() {
        recursionDepth++;
        if (recursionDepth > maxRecursionDepth) {
            maxRecursionDepth = recursionDepth;
        }
    }

    public void exitRecursion() {
        recursionDepth--;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getMaxRecursionDepth() {
        return maxRecursionDepth;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        recursionDepth = 0;
        maxRecursionDepth = 0;
    }
}
