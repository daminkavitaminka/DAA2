package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import main.java.algorithms.BoyerMooreMajorityVote;
import org.junit.jupiter.api.Test;

public class BoyerMooreMajorityVoteTest {
    @Test
    public void testMajorityElement() {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int result = BoyerMooreMajorityVote.majorityElement(nums);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testNoMajorityElement() {
        int[] nums = {3, 1, 2};
        int result = BoyerMooreMajorityVote.majorityElement(nums);
        Assertions.assertNotEquals(-1, result);
    }
}