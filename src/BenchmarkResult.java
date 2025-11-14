public class BenchmarkResult {

    private final int n;
    private final double durationMs;
    private final int matchesCount;

    public BenchmarkResult(int n, double durationMs, int matchesCount) {
        this.n = n;
        this.durationMs = durationMs;
        this.matchesCount = matchesCount;
    }

    public int getN() {
        return n;
    }

    public double getDurationMs() {
        return durationMs;
    }

    public int getMatchesCount() {
        return matchesCount;
    }
}
