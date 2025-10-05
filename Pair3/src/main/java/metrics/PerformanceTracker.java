package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long arrayReads;
    private long arrayWrites;
    private long assignments;

    private long usedMemoryBytes;

    public void incComparison() { comparisons++; }
    public void incRead() { arrayReads++; }
    public void incWrite() { arrayWrites++; }
    public void incAssign() { assignments++; }

    public long getComparisons() { return comparisons; }
    public long getArrayReads() { return arrayReads; }
    public long getArrayWrites() { return arrayWrites; }
    public long getAssignments() { return assignments; }

    public void setUsedMemoryBytes(long usedMemoryBytes) { this.usedMemoryBytes = usedMemoryBytes; }
    public long getUsedMemoryBytes() { return usedMemoryBytes; }

    public void reset() {
        comparisons = arrayReads = arrayWrites = assignments = 0;
        usedMemoryBytes = 0;
    }
}