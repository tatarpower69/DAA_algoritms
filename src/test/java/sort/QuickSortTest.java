package sort;

import org.junit.jupiter.api.Test;
import ru.edu.ilnur.algos.sort.QuickSort;
import ru.edu.ilnur.algos.util.Metrics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testRandomArray() {
        int[] arr = {5, 3, 8, 4, 2};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[]{2, 3, 4, 5, 8}, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {9, 7, 5, 3, 1};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[]{}, arr);
    }
}
