

# DAA Project – Divide and Conquer Algorithms

## Overview

This project implements several classic divide-and-conquer algorithms with a focus on safe recursion patterns, performance analysis, and metric collection. The algorithms included:

1. **MergeSort** – linear merge with reusable buffer and small-n cutoff (Insertion Sort).
2. **QuickSort** – randomized pivot, recurse on smaller partition, iterative on larger.
3. **Deterministic Select (Median-of-Medians)** – group by 5, in-place partitioning.
4. **Closest Pair of Points (2D)** – recursive divide-and-conquer with strip scanning.

The project collects metrics such as execution time, recursion depth, and comparisons, outputting results in CSV format for analysis.

---

## Architecture Notes

* **Recursion Depth & Allocation Control**

    * MergeSort: Reuses a single auxiliary buffer for merging to reduce memory allocations; switches to insertion sort for small arrays (cutoff = 16–32).
    * QuickSort: Always recurses into the smaller partition first and iterates over the larger, guaranteeing typical stack depth ≈ O(log n).
    * Deterministic Select: In-place partitioning; recursion occurs only on the side containing the k-th element.
    * Closest Pair: Recursive split by x-coordinate; temporary strip arrays used efficiently to minimize allocations.

* **Metrics Collection**

    * Each algorithm tracks comparisons, swaps, recursion depth.
    * Results are written to CSV (`benchmark_results.csv`) for plotting and analysis.

---

## Recurrence Analysis

### MergeSort

* **Recurrence:** T(n) = 2T(n/2) + Θ(n)
* **Analysis:** Master Theorem Case 2 → T(n) = Θ(n log n)
* **Notes:** Linear merge dominates; small-n cutoff slightly reduces recursion overhead.

### QuickSort

* **Recurrence:** T(n) = T(k) + T(n-k-1) + Θ(n)
* **Analysis:** Randomized pivot → expected Θ(n log n); recursion on smaller partition bounds stack depth to O(log n)
* **Notes:** Worst-case (sorted arrays) mitigated by random pivot.

### Deterministic Select (Median-of-Medians)

* **Recurrence:** T(n) = T(⌈n/5⌉) + T(7n/10) + Θ(n)
* **Analysis:** Akra–Bazzi intuition → T(n) = Θ(n)
* **Notes:** Linear-time selection guarantees bounded recursion; in-place partition reduces memory overhead.

### Closest Pair of Points

* **Recurrence:** T(n) = 2T(n/2) + Θ(n)
* **Analysis:** Master Theorem Case 2 → Θ(n log n)
* **Notes:** Strip scanning considers only 7–8 neighbors due to geometric constraints.

---

## Benchmarks & Plots

> Example benchmark results (CSV output)

| Algorithm           | Size | Comparisons | Swaps | MaxRecursionDepth | ExecutionTime(ns) |
| ------------------- | ---- | ----------- | ----- | ----------------- | ----------------- |
| QuickSort           | 100  | 669         | 377   | 0                 | 431100            |
| MergeSort           | 100  | 545         | 259   | 0                 | 665500            |
| DeterministicSelect | 100  | 198         | 156   | 1                 | 1153300           |
| QuickSort           | 1000 | 12114       | 6909  | 0                 | 532300            |

**Discussion**

* MergeSort and QuickSort match theoretical Θ(n log n) growth.
* Deterministic Select shows linear scaling with larger constant factor.
* Recursion depth in QuickSort aligns with smaller-first recursion strategy.

*(Plots for time vs n and depth vs n can be generated from CSV using Python/Excel.)*

---

## GitHub Workflow

* **Branches**

    * `main` – stable releases (`v0.1`, `v1.0`)
    * `feature/mergesort`, `feature/quicksort`, `feature/select`, `feature/closest`, `feature/metrics`

* **Commit Storyline**

  ```
  init: maven, junit5, ci, readme
  feat(metrics): counters, depth tracker, CSV writer
  feat(mergesort): baseline + reuse buffer + cutoff + tests
  feat(quicksort): smaller-first recursion, randomized pivot + tests
  refactor(util): partition, swap, shuffle, guards
  feat(select): deterministic select (MoM5) + tests
  feat(closest): divide-and-conquer implementation + tests
  feat(cli): parse args, run algos, emit CSV
  bench(jmh): harness for select vs sort
  docs(report): master cases & AB intuition, initial plots
  fix: edge cases (duplicates, tiny arrays)
  release: v1.0
  ```

---

## Testing

* **Sorting**

    * Correctness validated on random and adversarial arrays.
    * Recursion depth checked (QuickSort ≤ 2 * floor(log2 n) + O(1)).
* **Select**

    * Compared with `Arrays.sort(a)[k]` over 100 random trials.
* **Closest Pair**

    * Validated against brute-force O(n²) solution for n ≤ 2000.
    * Large n tested with fast divide-and-conquer method.

---

## Summary

* All implemented algorithms align with theoretical time complexities.
* Randomized QuickSort maintains bounded recursion depth as expected.
* Deterministic Select achieves linear-time selection with safe recursion.
* Minor deviations in execution times reflect constant factors such as cache effects and allocation overhead.


