package sort;

import org.junit.jupiter.api.Test;
import ru.edu.ilnur.algos.sort.MergeSort;
import ru.edu.ilnur.algos.util.Metrics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};

        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
        System.out.println(metrics);
    }
}
