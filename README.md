# Divide & Conquer Algorithms — Report

## 1. Overview
This project implements several **classic divide-and-conquer algorithms** with metrics and tests:
- **MergeSort** (Case 2 of Master Theorem)
- **QuickSort** (randomized pivot, smaller-first recursion)
- (Planned) Deterministic Select (Median of Medians, O(n))
- (Planned) Closest Pair of Points (O(n log n))

The goal is to practice safe recursion patterns, measure performance, and compare theoretical and empirical results.

---

## 2. MergeSort

### Algorithm
MergeSort recursively splits the array into halves until subarrays of size 1 are reached, then merges them back in sorted order.  
Optimizations:
- **Reusable buffer** to reduce allocations
- **Cutoff to insertion sort** for very small arrays (constant-factor speedup)

### Recurrence Analysis

\[
T(n) = 2T(n/2) + Θ(n)
\]

**Master Theorem (Case 2):**
- a = 2, b = 2, f(n) = Θ(n)
- n^(log_b a) = n^(log_2 2) = n
- Since f(n) = Θ(n), Case 2 applies:

\[
T(n) = Θ(n \log n)
\]

### Complexity
- **Time:** Best/Worst/Average → Θ(n log n)
- **Space:** Θ(n) (merge buffer)

---

## 3. QuickSort

### Algorithm
QuickSort selects a pivot, partitions the array, then sorts the partitions.  
Optimizations:
- **Randomized pivot** – avoids adversarial input (O(n²) worst-case)
- **Smaller-first recursion** – guarantees recursion depth ≤ O(log n)
- Iterative processing of larger partition (stack space minimized)

### Recurrence Analysis
Average recurrence (randomized pivot, expected half split):

\[
T(n) = T(k) + T(n - k - 1) + Θ(n) ≈ 2T(n/2) + Θ(n)
\]

Same as MergeSort — Master Theorem Case 2 applies:

\[
T(n) = Θ(n \log n)
\]

Worst case (if pivot chosen poorly): T(n) = T(n-1) + Θ(n) = Θ(n²)  
But randomized pivot makes this extremely unlikely.

---

## 4. Metrics and Results

We measure:
- **Comparisons**
- **Swaps / moves**
- **Recursion depth**
- **Execution time**

Metrics are written to CSV for plotting.  
In experiments:
- MergeSort and QuickSort both follow Θ(n log n) growth.
- QuickSort recursion depth stays ≈ 2·log₂(n) as expected.

---

## 5. Summary

Theoretical predictions (Θ(n log n)) match experimental results.  
Randomized pivot ensures robust performance and keeps recursion depth logarithmic.  
Metrics confirm that MergeSort performs more memory moves, while QuickSort uses less extra space.

---

## 6. Next Steps

- Implement **Deterministic Select** (Median-of-Medians) and measure depth.
- Implement **Closest Pair of Points** (divide-and-conquer + strip check).
- Add JMH benchmarks to compare constant factors between algorithms.
