package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KadaneAlgorithmTest {

    @Test
    void classicExample_sumAndIndices() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        var res = KadaneAlgorithm.maxSubarray(a, new PerformanceTracker());

        assertEquals(6, res.maxSum);
        assertEquals(3, res.startIndex);
        assertEquals(6, res.endIndex);
    }

    @Test
    void allNegative_pickLargest() {
        int[] a = {-8,-3,-6,-2,-5,-4};
        var res = KadaneAlgorithm.maxSubarray(a, new PerformanceTracker());

        assertEquals(-2, res.maxSum);
        assertEquals(3, res.startIndex);
        assertEquals(3, res.endIndex);
    }

    @Test
    void allPositive_fullArray() {
        int[] a = {1,2,3,4};
        var res = KadaneAlgorithm.maxSubarray(a, new PerformanceTracker());

        assertEquals(10, res.maxSum);
        assertEquals(0, res.startIndex);
        assertEquals(3, res.endIndex);
    }

    @Test
    void empty_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> KadaneAlgorithm.maxSubarray(new int[0], new PerformanceTracker()));
    }
}