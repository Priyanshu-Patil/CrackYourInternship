    class Solution {
    public void solve(int n, int open, int close, String str, List<String> ans) {
        if (str.length() == n * 2) {
            ans.add(str);
            return;
        }
        if (open < n) {
            solve(n, open + 1, close, str + "(", ans);
        }
        if (close < open) {
            solve(n, open, close + 1, str + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, "", ans);
        return ans;
    }
}