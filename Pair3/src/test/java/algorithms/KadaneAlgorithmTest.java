package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import main.java.algorithms.KadaneAlgorithm;
import org.junit.jupiter.api.Test;

public class KadaneAlgorithmTest {
    @Test
    public void testMaxSubArraySum() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = KadaneAlgorithm.maxSubArraySum(nums);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {1};
        int result = KadaneAlgorithm.maxSubArraySum(nums);
        Assertions.assertEquals(1, result);
    }
}