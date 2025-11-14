public class TestStringGenerator {


    public static String generateText(int n) { // (generate text of length n)
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append('a'); // (filling with 'a's)
        }
        return sb.toString(); // (return generated text)
    }
}
