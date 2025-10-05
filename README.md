
# Assignment 2 — Pair 3: Boyer–Moore & Kadane algorithms

This project implements and benchmarks two linear-time array algorithms:

- **Boyer–Moore Majority Vote**: Majority element detection (`> n/2` occurrences) with optional verification.
- **Kadane’s Algorithm**: Maximum subarray sum **with start/end position tracking**.

It also includes a simple CLI benchmark runner, metrics tracking, and JUnit tests that cover edge cases.

## How to Build & Test

```bash
mvn -q -e -DskipTests=false test
mvn -q -DskipTests package
```

## Run CLI Benchmarks

```bash

java -cp target/assignment2-pair3-1.0.0.jar cli.BenchmarkRunner --algorithm=kadane --n=100000 --trials=5 --dist=random --csv=docs/performance-plots/kadane.csv

java -cp target/assignment2-pair3-1.0.0.jar cli.BenchmarkRunner --algorithm=boyer --n=100000 --trials=5 --dist=majority --csv=docs/performance-plots/boyer.csv
```

**Distributions** supported: `random`, `allneg`, `allpos`, `nearly-sorted`, `reverse`, `majority`.

CSV columns: `algorithm,n,trial,time_nanos,array_reads,array_writes,comparisons,assignments,used_memory_bytes`

## Student Responsibilities (Pair 3)

- **Student A — Boyer–Moore**:
    1. Own `algorithms.BoyerMooreMajorityVote` and its tests.
    2. Ensure **verification** step is correct (returns `-1` when no majority).
    3. Integrate `PerformanceTracker` counters (reads, comparisons, assignments).
    4. Add benchmark scenarios: `majority`, `random`, `nearly-sorted`.

- **Student B — Kadane**:
    1. Own `algorithms.KadaneAlgorithm` and its tests.
    2. Ensure **position tracking** (`startIndex`, `endIndex`) is correct.
    3. Integrate `PerformanceTracker` counters (reads, assignments).
    4. Add benchmark scenarios: `allneg`, `allpos`, `random`, `reverse`.

- **Both**:
    - Keep branch strategy and commits as per the rubric.
    - Contribute to CLI benchmark runner improvements and plots (CSV → Excel/Sheets plot).

## Branch Strategy

- `main` — only stable releases (tag `v1.0`)
- `feature/algorithm` — implementation
- `feature/metrics` — tracking
- `feature/testing` — tests
- `feature/cli` — CLI
- `feature/optimization` — improvements

## Notes

- Package names follow Maven conventions (`src/main/java/algorithms/...` → `package algorithms;` etc.).
- The provided `PerformanceTracker` is minimal and intentionally simple (counts logical operations and approximates memory with `Runtime`). Extend if needed.
