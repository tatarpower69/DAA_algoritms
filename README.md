# MergeSort Implementation with Metrics

## Description
This project implements the **MergeSort** algorithm using a classic **Divide & Conquer** approach.

## Algorithm
MergeSort recursively splits the array into halves until the base case of size 1 is reached, then merges them back in sorted order.

### Recurrence Relation

T(n) = 2T(n/2) + Θ(n)

By the **Master Theorem (Case 2)**:

- **a = 2**, **b = 2**, **f(n) = Θ(n)**
- Case 2 of Master Theorem applies:  
  `T(n) = Θ(n log n)`

### Complexity
- **Best / Worst / Average:** Θ(n log n)
- **Space Complexity:** Θ(n)

## Metrics
Metrics are collected during sorting:
- Number of comparisons
- Number of swaps
- Execution time (ms)

Results are saved into CSV file via `CSVWriter`.

## Tests
Unit tests are located in:

They cover:
- Sorting of random arrays
- Edge cases (empty array, single element)
- Already sorted and reversed arrays
# Divide and Conquer Algorithms

## QuickSort

### Algorithm
QuickSort is a classic **divide-and-conquer** algorithm:
1. Choose a **pivot** (we use randomized pivot for robustness).
2. Partition the array into two parts: elements smaller than the pivot and elements greater than the pivot.
3. Recursively sort the partitions.

To optimize recursion:
- We **always recurse on the smaller partition**, and handle the larger one iteratively (loop).
- This ensures recursion depth is bounded by `O(log n)`.

### Modifications
- **Randomized pivot** – avoids adversarial worst-case input (`O(n²)`).
- **Smaller-first recursion** – stack depth control.
- Integrated metrics:
    - number of comparisons,
    - recursion depth,
    - execution time.

### Recurrence Analysis
The recurrence for QuickSort is:

T(n) = T(k) + T(n - k - 1) + Θ(n), where k is the pivot position.
On average, the pivot splits the array roughly in half:

T(n) = 2T(n/2) + Θ(n).
By the **Master Theorem (Case 2)**:

a = 2, b = 2, 
f(n) = Θ(n)


n^(log_b a) = n^(log_2 2) = n

f(n) = Θ(n)

Thus:T(n) = Θ(n log n)

### Experimental Notes
- With randomized pivot, recursion depth stays around `≈ 2 * log₂(n)`.
- The number of comparisons matches the theoretical expectation within constant factors.
- For small arrays, insertion sort cut-off could further improve performance (future optimization).
