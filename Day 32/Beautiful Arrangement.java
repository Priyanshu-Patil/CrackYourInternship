class Solution {
    int ans = 0;
    public int countArrangement(int n) {
        if (n == 0) return 0;
        solve(1, n, new int[n + 1]);

        return ans;
    }

    public void solve(int pos, int n, int[] usedValueArr) {
        if (pos > n) {
            ans++;
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (usedValueArr[i] == 0 && (pos % i == 0 || i % pos == 0)) {
                usedValueArr[i] = 1;
                solve(pos + 1, n, usedValueArr);
                usedValueArr[i] = 0;
            }
        }
    }
}