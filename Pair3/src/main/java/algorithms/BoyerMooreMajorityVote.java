package algorithms;

import metrics.PerformanceTracker;

public final class BoyerMooreMajorityVote {
    private BoyerMooreMajorityVote() {}

    public static int majorityElement(int[] a, PerformanceTracker t, boolean verify) {
        if (a == null || a.length == 0)
            throw new IllegalArgumentException("Array must be non-empty");

        int candidate = 0;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            t.incRead();
            int x = a[i];

            if (count == 0) {
                candidate = x; t.incAssign();
                count = 1; t.incAssign();
            }
            else {
                t.incComparison();

                if (x == candidate) {
                    count++; t.incAssign();
                }
                else {
                    count--; t.incAssign();
                }
            }
        }

        if (!verify) return candidate;

        int occurrences = 0;

        for (int i = 0; i < a.length; i++) {
            t.incRead(); t.incComparison();

            if (a[i] == candidate) occurrences++;
        }

        return (occurrences > a.length / 2) ? candidate : -1;
    }
}