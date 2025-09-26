package org.example.util;


public class Metrics {
    private int comparisons = 0;
    private int swaps = 0;
    private int recursionDepth = 0;
    private int maxDepth = 0;

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }

    public void enterRecursion() {
        recursionDepth++;
        if (recursionDepth > maxDepth) {
            maxDepth = recursionDepth;
        }
    }

    public void exitRecursion() {
        recursionDepth--;
    }

    public int getComparisons() { return comparisons; }
    public int getSwaps() { return swaps; }
    public int getMaxDepth() { return maxDepth; }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        recursionDepth = 0;
        maxDepth = 0;
    }
}
