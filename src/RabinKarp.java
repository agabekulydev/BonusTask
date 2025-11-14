import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 911382323L;


    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        int n = text.length(); // (length of text)
        int m = pattern.length(); // (length of pattern)

        if (m == 0 || m > n) { // (edge cases)
            return result;
        }

        long patternHash = 0;
        long windowHash = 0;
        long basePower = 1; // BASE^(m-1) % MOD


        for (int i = 0; i < m; i++) { // (initial hash computation)
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + text.charAt(i)) % MOD;

            if (i < m - 1) {
                basePower = (basePower * BASE) % MOD; // (precompute BASE^(m-1))
            }
        }


        for (int i = 0; i <= n - m; i++) { // (slide over text)

            if (patternHash == windowHash) { // (hashes match)
                if (compareSubstring(text, pattern, i)) {
                    result.add(i);
                }
            }


            if (i < n - m) { // (update hash for next window)
                char oldChar = text.charAt(i);
                char newChar = text.charAt(i + m);

                windowHash = (windowHash - oldChar * basePower) % MOD;
                if (windowHash < 0) {
                    windowHash += MOD;
                }

                windowHash = (windowHash * BASE + newChar) % MOD;
            }
        }

        return result; // (return all match starting indices)
    }


    private static boolean compareSubstring(String text, String pattern, int start) { // (verify match)
        for (int j = 0; j < pattern.length(); j++) { // (character by character comparison)
            if (text.charAt(start + j) != pattern.charAt(j)) { // (mismatch found)
                return false;
            }
        }
        return true; // (exact match confirmed)
    }
}
