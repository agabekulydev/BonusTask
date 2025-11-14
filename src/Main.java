public class Main {

    public static void main(String[] args) {
        warmUp("aa");

        String pattern = "aa";                       // (pattern to search)
        int[] sizes = {1, 10, 100, 1000, 10000};         // (sizes of text to test)

        PerformanceTester tester = new PerformanceTester(pattern);

        System.out.println("Rabin–Karp Benchmark");
        System.out.println("Pattern: \"" + pattern + "\"");
        System.out.println("--------------------------------");

        for (int n : sizes) {
            BenchmarkResult result = tester.run(n);
            System.out.printf(
                    "n = %-6d | time = %.4f ms | matches = %d%n",
                    result.getN(),
                    result.getDurationMs(),   // double → %.4f
                    result.getMatchesCount()
            );
        }
    }

    private static void warmUp(String pattern) {
        PerformanceTester warmTester = new PerformanceTester(pattern);


        int[] warmSizes = {1, 10, 50, 100, 200}; // (sizes for warm-up)
        for (int n : warmSizes) {
            warmTester.run(n); // (run warm-up tests)
        }
    }
}
