package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityVoteTest {

    @Test
    void majorityExists_middle() {
        int[] a = {2,2,1,2,3,2,2};
        int res = BoyerMooreMajorityVote.majorityElement(a, new PerformanceTracker(), true);

        assertEquals(2, res);
    }

    @Test
    void noMajority_returnsMinusOne() {
        int[] a = {1,2,3,2,3,1};
        int res = BoyerMooreMajorityVote.majorityElement(a, new PerformanceTracker(), true);
        assertEquals(-1, res);
    }

    @Test
    void singleElement_isMajority() {
        int[] a = {42};
        int res = BoyerMooreMajorityVote.majorityElement(a, new PerformanceTracker(), true);
        assertEquals(42, res);
    }

    @Test
    void empty_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> BoyerMooreMajorityVote.majorityElement(new int[0], new PerformanceTracker(), true));
    }
}