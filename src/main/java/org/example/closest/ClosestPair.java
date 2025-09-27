package org.example.closest;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double findClosestPair(Point[] points) {
        Point[] pointsByX = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsByX, Comparator.comparingDouble(p -> p.x));

        Point[] aux = new Point[points.length];
        return closest(pointsByX, aux, 0, points.length - 1);
    }

    private static double closest(Point[] pointsByX, Point[] aux, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(pointsByX, left, right);
        }

        int mid = (left + right) / 2;
        double midX = pointsByX[mid].x;

        double dl = closest(pointsByX, aux, left, mid);
        double dr = closest(pointsByX, aux, mid + 1, right);
        double d = Math.min(dl, dr);

        int stripSize = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(pointsByX[i].x - midX) < d) {
                aux[stripSize++] = pointsByX[i];
            }
        }

        Arrays.sort(aux, 0, stripSize, Comparator.comparingDouble(p -> p.y));

        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (aux[j].y - aux[i].y) < d; j++) {
                double dist = distance(aux[i], aux[j]);
                if (dist < d) {
                    d = dist;
                }
            }
        }
        return d;
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    private static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
