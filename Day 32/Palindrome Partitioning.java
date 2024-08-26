class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s, 0, ans, temp);

        return ans;
    }

    public void solve(String s, int partIdx, List<List<String>> ans, List<String> temp) {
        if (partIdx == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = partIdx; i < s.length(); ++i) {
            if (isPalindrome(s, partIdx, i)) {
                temp.add(s.substring(partIdx, i + 1));
                solve(s, i + 1, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;  
        }

        return true;
    }
}