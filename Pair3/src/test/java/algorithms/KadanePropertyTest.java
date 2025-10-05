package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class KadanePropertyTest {

    private static int bruteMaxSum(int[] a) {
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = i; j < a.length; j++) {
                sum += a[j];

                if (sum > best) best = sum;
            }
        }

        return best;
    }

    @Test
    void randomArraysAgreeWithBruteForce() {
        Random rnd = new Random(12345);
        for (int t = 0; t < 20; t++) {
            int n = 1 + rnd.nextInt(100);
            int[] a = new int[n];

            for (int i = 0; i < n; i++) a[i] = rnd.nextInt(2001) - 1000;

            var res = KadaneAlgorithm.maxSubarray(a, new PerformanceTracker());
            assertEquals(bruteMaxSum(a), res.maxSum);
        }
    }
}