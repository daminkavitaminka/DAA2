package main.java.cli;

import main.java.algorithms.BoyerMooreMajorityVote;
import main.java.algorithms.KadaneAlgorithm;
import main.java.metrics.PerformanceTracker;

public class BenchmarkRunner {
    public static void main(String[] args) {
        PerformanceTracker tracker = new PerformanceTracker();

        // Test with different input sizes
        int[] smallArray = {1, 2, 3, 4, 5};
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i + 1;
        }

        // Boyer-Moore Majority Vote
        BoyerMooreMajorityVote.majorityElement(smallArray);
        BoyerMooreMajorityVote.majorityElement(largeArray);

        // Kadane's Algorithm
        KadaneAlgorithm.maxSubArraySum(smallArray);
        KadaneAlgorithm.maxSubArraySum(largeArray);

        // Output the performance metrics
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
    }
}