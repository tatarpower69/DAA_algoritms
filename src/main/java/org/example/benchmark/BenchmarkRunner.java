package org.example.benchmark;

import org.example.sort.MergeSort;
import org.example.sort.QuickSort;
import org.example.select.DeterministicSelect;
import org.example.util.CSVWriter;
import org.example.util.Metrics;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    private static final int[] SIZES = {100, 1000, 5000, 10000};

    public static void main(String[] args) throws IOException {
        CSVWriter writer = new CSVWriter("benchmark_results.csv");
        writer.write("Algorithm,Size,Comparisons,Swaps,MaxRecursionDepth,ExecutionTime(ns)", "");

        for (int size : SIZES) {
            int[] data = generateRandomArray(size, 0, size * 10);

            benchmarkQuickSort(data.clone(), writer, size);
            benchmarkMergeSort(data.clone(), writer, size);
            benchmarkDeterministicSelect(data.clone(), writer, size);
        }

        System.out.println("✅ Benchmark complete! Results saved to benchmark_results.csv");
    }

    private static void benchmarkQuickSort(int[] data, CSVWriter writer, int size) throws IOException {
        Metrics metrics = new Metrics();
        long start = System.nanoTime();
        QuickSort.sort(data, metrics);
        long execTime = System.nanoTime() - start;

        String line = String.format("QuickSort,%d,%d,%d,%d,%d",
                size, metrics.getComparisons(), metrics.getSwaps(), metrics.getMaxRecursionDepth(), execTime);
        writer.write("", line);
    }

    private static void benchmarkMergeSort(int[] data, CSVWriter writer, int size) throws IOException {
        Metrics metrics = new Metrics();
        long start = System.nanoTime();
        MergeSort.sort(data, metrics);
        long execTime = System.nanoTime() - start;

        String line = String.format("MergeSort,%d,%d,%d,%d,%d",
                size, metrics.getComparisons(), metrics.getSwaps(), metrics.getMaxRecursionDepth(), execTime);
        writer.write("", line);
    }

    private static void benchmarkDeterministicSelect(int[] data, CSVWriter writer, int size) throws IOException {
        Metrics metrics = new Metrics();
        DeterministicSelect select = new DeterministicSelect(metrics);

        int k = size / 2;
        select.select(data, k);

        String line = String.format("DeterministicSelect,%d,%d,%d,%d,%d",
                size, metrics.getComparisons(), metrics.getSwaps(), metrics.getMaxRecursionDepth(), metrics.getExecutionTime());
        writer.write("", line);
    }

    private static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        return random.ints(size, min, max).toArray();
    }
}
