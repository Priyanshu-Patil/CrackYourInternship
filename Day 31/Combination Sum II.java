class Solution {
    void solve(int[] candidates, int target, int idx, List<Integer> temp, List<List<Integer>> ans) {
        if (target < 0) return;

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; ++i) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            temp.add(candidates[i]);

            solve(candidates, target - candidates[i], i + 1, temp, ans);

            temp.remove(temp.size() - 1);        
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates); //to handle duplicates
        solve(candidates, target, 0, temp, ans);

        return ans;
    }
}