import java.util.List;

public class PerformanceTester {

    private final String pattern;

    public PerformanceTester(String pattern) {
        this.pattern = pattern;
    }

    public BenchmarkResult run(int n) {
        String text = TestStringGenerator.generateText(n); // (generate text of length n)


        for (int i = 0; i < 100; i++) { // (warm-up)
            RabinKarp.search(text, pattern);
        }

        int iterations = 1000; // (number of iterations for averaging)
        long totalNs = 0;
        int matchesCount = 0;

        for (int i = 0; i < iterations; i++) {
            long startNs = System.nanoTime(); // (start time)
            List<Integer> matches = RabinKarp.search(text, pattern); // (perform search)
            long endNs = System.nanoTime(); // (end time)

            totalNs += (endNs - startNs); // (accumulate duration)
            matchesCount = matches.size(); // (store matches count from last iteration)
        }

        double avgNs = (double) totalNs / iterations;
        double durationMs = avgNs / 1_000_000.0; // (convert to milliseconds)

        return new BenchmarkResult(n, durationMs, matchesCount);
    }
}
