package select;

import org.example.util.Metrics;
import org.junit.jupiter.api.Test;
import org.example.select.DeterministicSelect;

import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSelectMiddleElement() {
        int[] arr = {7, 2, 9, 4, 1, 5};
        Metrics metrics = new Metrics();
        DeterministicSelect selector = new DeterministicSelect(metrics);


        int result = selector.select(arr, 2);
        assertEquals(4, result);
    }

    @Test
    void testSelectMinElement() {
        int[] arr = {42, 17, 8, 99, 5};
        Metrics metrics = new Metrics();
        DeterministicSelect selector = new DeterministicSelect(metrics);

        int result = selector.select(arr, 0);
        assertEquals(5, result);
    }

    @Test
    void testSelectMaxElement() {
        int[] arr = {10, 30, 20, 50, 40};
        Metrics metrics = new Metrics();
        DeterministicSelect selector = new DeterministicSelect(metrics);

        int result = selector.select(arr, arr.length - 1);
        assertEquals(50, result);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {123};
        Metrics metrics = new Metrics();
        DeterministicSelect selector = new DeterministicSelect(metrics);

        int result = selector.select(arr, 0);
        assertEquals(123, result);
    }

    @Test
    void testMetricsCollected() {
        int[] arr = {9, 1, 4, 7, 3, 6};
        Metrics metrics = new Metrics();
        DeterministicSelect selector = new DeterministicSelect(metrics);

        selector.select(arr, 3);

        assertTrue(metrics.getComparisons() > 0, "Должны быть сравнения");
        assertTrue(metrics.getSwaps() > 0, "Должны быть свапы");
        assertTrue(metrics.getMaxRecursionDepth() > 0, "Должна учитываться глубина рекурсии");
        assertTrue(metrics.getExecutionTime() > 0, "Время должно измеряться");
    }

    @Test
    void testInvalidK() {
        int[] arr = {1, 2, 3};
        Metrics metrics = new Metrics();
        DeterministicSelect selector = new DeterministicSelect(metrics);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> selector.select(arr, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> selector.select(arr, 3));
    }
}
