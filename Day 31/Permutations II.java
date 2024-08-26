class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        solve(ans, temp, nums, used);

        return ans;
    }

    void solve(List<List<Integer>> ans,List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            //for duplicates
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            temp.add(nums[i]);
            solve(ans, temp, nums, used);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}