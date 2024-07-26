class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] will be storing the count of subsequences of s[0..i-1] that equals t[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Every string has at least one subsequence: the empty string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters don't match, just take the value from above (excluding the current character of s)
                dp[i][j] = dp[i - 1][j];
                
                // If the characters match, add the value from the left diagonal cell (including the current character of s)
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        // The answer will be in the bottom-right cell
        return dp[m][n];
    }
}