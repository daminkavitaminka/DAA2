package algorithms;

import metrics.PerformanceTracker;

public final class KadaneAlgorithm {
    private KadaneAlgorithm() {}

    public static final class KadaneResult {
        public final int maxSum;
        public final int startIndex;
        public final int endIndex;

        public KadaneResult(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        @Override public String toString() {
            return "KadaneResult{sum=" + maxSum + ", start=" + startIndex + ", end=" + endIndex + "}";
        }
    }

    public static KadaneResult maxSubarray(int[] a, PerformanceTracker t) {
        if (a == null || a.length == 0)
            throw new IllegalArgumentException("Array must be non-empty");

        int maxSoFar = a[0]; t.incRead(); t.incAssign();
        int maxEndingHere = a[0]; t.incAssign();
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < a.length; i++) {
            t.incRead(); t.incComparison();
            int val = a[i];
            t.incComparison();

            if (val > maxEndingHere + val) {
                maxEndingHere = val; t.incAssign();
                tempStart = i; t.incAssign();
            }
            else {
                maxEndingHere = maxEndingHere + val; t.incAssign();
            } t.incComparison();

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere; t.incAssign();
                start = tempStart; t.incAssign();
                end = i; t.incAssign();
            }
        }

        return new KadaneResult(maxSoFar, start, end);
    }
}