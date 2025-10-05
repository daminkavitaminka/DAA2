package util;

import java.util.Random;

public final class ArrayGenerators {
    private ArrayGenerators() {}

    public static int[] randomInts(int n, long seed) {
        Random rnd = new Random(seed);

        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = rnd.nextInt(200_001) - 100_000;

        return a;
    }

    public static int[] allPositive(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = i + 1;

        return a;
    }

    public static int[] allNegative(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = - (i + 1);

        return a;
    }

    public static int[] nearlySorted(int n, long seed, double swapRate) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = i;

        Random rnd = new Random(seed);

        int swaps = Math.max(1, (int)(n * swapRate));

        for (int s = 0; s < swaps; s++) {
            int i = rnd.nextInt(n);
            int j = rnd.nextInt(n);
            int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        }

        return a;
    }

    public static int[] reverse(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = n - i;

        return a;
    }

    public static int[] withMajority(int n, long seed) {
        int[] a = randomInts(n, seed);
        int majorityCount = (n / 2) + 1;

        for (int i = 0; i < majorityCount; i++) a[i] = 7;

        return a;
    }
}