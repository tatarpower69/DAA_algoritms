package closest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.closest.Point;
import org.example.closest.ClosestPair;

public class ClosestPairTest {

    @Test
    void testTwoPoints() {
        Point[] points = { new Point(0, 0), new Point(3, 4) };
        double result = ClosestPair.findClosestPair(points);
        assertEquals(5.0, result, 1e-9);
    }

    @Test
    void testThreePoints() {
        Point[] points = { new Point(0, 0), new Point(1, 1), new Point(4, 5) };
        double result = ClosestPair.findClosestPair(points);
        assertEquals(Math.sqrt(2), result, 1e-9);
    }

    @Test
    void testFourPointsSquare() {
        Point[] points = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 0),
                new Point(1, 1)
        };
        double result = ClosestPair.findClosestPair(points);
        assertEquals(1.0, result, 1e-9);
    }

    @Test
    void testRandomPoints() {
        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };
        double result = ClosestPair.findClosestPair(points);
        assertEquals(Math.sqrt(2), result, 1e-9); // (2,3) и (3,4)
    }

    @Test
    void testIdenticalPoints() {
        Point[] points = {
                new Point(1, 1),
                new Point(1, 1),
                new Point(2, 2)
        };
        double result = ClosestPair.findClosestPair(points);
        assertEquals(0.0, result, 1e-9);
    }
}
