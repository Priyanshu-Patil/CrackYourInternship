import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    private static final int BASE = 256; // Base value for hashing
    private static final int MOD = 101;  // A prime number to reduce hash collisions

    // Function to compute the hash value of a string
    private static int computeHash(String str, int end) {
        int hash = 0;
        for (int i = 0; i < end; i++) {
            hash = (hash * BASE + str.charAt(i)) % MOD;
        }
        return hash;
    }

    // Function to update the hash value when the window slides
    private static int rollingHash(int hash, char oldChar, char newChar, int base, int highestPower) {
        hash = (hash - oldChar * highestPower) % MOD;
        hash = (hash * base) % MOD;
        hash = (hash + newChar) % MOD;
        if (hash < 0) hash += MOD;
        return hash;
    }

    public static List<Integer> rabinKarpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        if (m > n) return result;

        int patternHash = computeHash(pattern, m);
        int textHash = computeHash(text, m);

        int highestPower = 1;
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    result.add(i);
                }
            }
            if (i < n - m) {
                textHash = rollingHash(textHash, text.charAt(i), text.charAt(i + m), BASE, highestPower);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        List<Integer> matches = rabinKarpSearch(text, pattern);

        System.out.println("Pattern found at positions: " + matches);
    }
}
