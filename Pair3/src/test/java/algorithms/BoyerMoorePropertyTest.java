package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMoorePropertyTest {

    @Test
    void majorityInjectedIsFound() {
        int n = 101;
        int[] a = new int[n];

        Random rnd = new Random(777);

        for (int i = 0; i < n; i++) a[i] = rnd.nextInt(5);

        for (int i = 0; i < (n/2)+1; i++) a[i] = 7;

        int res = BoyerMooreMajorityVote.majorityElement(a, new PerformanceTracker(), true);
        assertEquals(7, res);
    }

    @Test
    void noMajorityReturnsMinusOne() {
        int[] a = {1,2,1,2,3,3};
        int res = BoyerMooreMajorityVote.majorityElement(a, new PerformanceTracker(), true);

        assertEquals(-1, res);
    }
}