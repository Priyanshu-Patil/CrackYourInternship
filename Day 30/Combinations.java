class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(1, temp, result, n, k);

        return result;
    }

    void solve(int start, List<Integer> temp, List<List<Integer>> result, int n, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num = start; num <= n; num++) {
            temp.add(num);
            solve(num + 1, temp, result, n, k);
            temp.remove(temp.size() - 1);
        }
    }
}