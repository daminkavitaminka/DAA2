package cli;

import algorithms.BoyerMooreMajorityVote;
import algorithms.KadaneAlgorithm;
import algorithms.KadaneAlgorithm.KadaneResult;
import metrics.PerformanceTracker;
import util.ArrayGenerators;
import util.CsvWriter;

public final class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        String algorithm = "kadane";
        int n = 10000;
        int trials = 3;
        String dist = "random";
        String csv = "docs/performance-plots/results.csv";

        for (String arg : args) {
            if (arg.startsWith("--algorithm=")) algorithm = arg.substring("--algorithm=".length());
            else if (arg.startsWith("--n=")) n = Integer.parseInt(arg.substring("--n=".length()));
            else if (arg.startsWith("--trials=")) trials = Integer.parseInt(arg.substring("--trials=".length()));
            else if (arg.startsWith("--dist=")) dist = arg.substring("--dist=".length());
            else if (arg.startsWith("--csv=")) csv = arg.substring("--csv=".length());
        }

        try (CsvWriter out = new CsvWriter(csv)) {
            out.writeHeaderIfEmpty("algorithm,n,trial,time_nanos,array_reads,array_writes,comparisons,assignments,used_memory_bytes");

            for (int trial = 1; trial <= trials; trial++) {
                int[] a = switch (dist) {
                    case "allneg" -> ArrayGenerators.allNegative(n);
                    case "allpos" -> ArrayGenerators.allPositive(n);
                    case "nearly-sorted" -> ArrayGenerators.nearlySorted(n, 42L + trial, 0.01);
                    case "reverse" -> ArrayGenerators.reverse(n);
                    case "majority" -> ArrayGenerators.withMajority(n, 1234L + trial);
                    default -> ArrayGenerators.randomInts(n, 123L + trial);
                };

                PerformanceTracker t = new PerformanceTracker();
                long memBefore = usedMemory();
                long start = System.nanoTime();

                if (algorithm.equalsIgnoreCase("boyer")) {
                    int result = BoyerMooreMajorityVote.majorityElement(a, t, true);

                    if (n <= 20) System.out.println("Majority=" + result);
                }
                else if (algorithm.equalsIgnoreCase("kadane")) {
                    KadaneResult res = KadaneAlgorithm.maxSubarray(a, t);

                    if (n <= 20) System.out.println(res);
                }
                else {
                    throw new IllegalArgumentException("Unknown --algorithm=" + algorithm);
                }

                long end = System.nanoTime();
                long memAfter = usedMemory();
                t.setUsedMemoryBytes(Math.max(0, memAfter - memBefore));

                String row = String.join(",",
                        algorithm, String.valueOf(n), String.valueOf(trial),
                        String.valueOf(end - start),
                        String.valueOf(t.getArrayReads()),
                        String.valueOf(t.getArrayWrites()),
                        String.valueOf(t.getComparisons()),
                        String.valueOf(t.getAssignments()),
                        String.valueOf(t.getUsedMemoryBytes())
                );
                out.writeRow(row);
            }
        }
        System.out.println("Done. CSV written to " + csv);
    }

    private static long usedMemory() {
        System.gc();
        Runtime rt = Runtime.getRuntime();

        return rt.totalMemory() - rt.freeMemory();
    }
}