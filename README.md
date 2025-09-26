# MergeSort Implementation with Metrics

## Description
This project implements the **MergeSort** algorithm using a classic **Divide & Conquer** approach.

## Algorithm
MergeSort recursively splits the array into halves until the base case of size 1 is reached, then merges them back in sorted order.

### Recurrence Relation

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
