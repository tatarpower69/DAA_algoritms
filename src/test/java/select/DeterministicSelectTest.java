package sort;

import org.junit.jupiter.api.Test;
import ru.edu.ilnur.algos.select.DeterministicSelect;
import ru.edu.ilnur.algos.util.Metrics;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectTest {

    @Test
    void testCorrectnessOnRandomArray() {
        Random random = new Random();
        int[] arr = random.ints(20, 0, 100).toArray();
        int k = 5;

        Metrics metrics = new Metrics();
        DeterministicSelect ds = new DeterministicSelect(metrics);
        int result = ds.select(Arrays.copyOf(arr, arr.length), k);

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        assertEquals(sorted[k], result);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        Metrics metrics = new Metrics();
        DeterministicSelect ds = new DeterministicSelect(metrics);
        assertEquals(42, ds.select(arr, 0));
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {5, 1, 5, 1, 5, 1, 5, 1};
        Metrics metrics = new Metrics();
        DeterministicSelect ds = new DeterministicSelect(metrics);
        int result = ds.select(arr, 4);

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        assertEquals(sorted[4], result);
    }
}
