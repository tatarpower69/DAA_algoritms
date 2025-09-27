package org.example.util;


public class Metrics {
    private long comparisons;
    private long swaps;
    private long recursionDepth;
    private long maxRecursionDepth;
    private long executionTime;


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
        if (recursionDepth > 0) recursionDepth--;
    }


    public void setExecutionTime(long nanos) {
        executionTime = nanos;
    }


    public long getExecutionTime() {
        return executionTime;
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
        executionTime = 0;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "comparisons=" + comparisons +
                ", swaps=" + swaps +
                ", maxRecursionDepth=" + maxRecursionDepth +
                ", executionTime=" + executionTime + " ns" +
                '}';
    }
}
