package algorithms;

public class BoyerMooreMajorityVote {
    public static int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}