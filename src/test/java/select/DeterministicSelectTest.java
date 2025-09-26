package select;

import org.junit.jupiter.api.Test;
import ru.edu.ilnur.algos.select.DeterministicSelect;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectTest {

    @Test
    void testSmallArray() {
        int[] arr = {7, 2, 9, 4, 1};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        assertEquals(sorted[0], DeterministicSelect.select(arr.clone(), 0));
        assertEquals(sorted[sorted.length - 1], DeterministicSelect.select(arr.clone(), arr.length - 1));
    }

    @Test
    void testRandomArray() {
        Random rnd = new Random(42);
        int[] arr = rnd.ints(100, 0, 1000).toArray();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < arr.length; k += 10) {
            int expected = sorted[k];
            int actual = DeterministicSelect.select(arr.clone(), k);
            assertEquals(expected, actual, "Mismatch at k=" + k);
        }
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }
}
