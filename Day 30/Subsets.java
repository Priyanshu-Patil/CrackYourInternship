class Solution {
    List<List<Integer>> subsetsHelper(int[] nums, int i) {
        // Base Case
        if(i == -1) {
            List< List<Integer> > ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            return ans;
        }

        List< List<Integer> > partialAns = new ArrayList(subsetsHelper(nums, i - 1));
        List< List<Integer> > ans = new ArrayList<>();

        // copy everything from partial Ans
        for(List<Integer> subset : partialAns) {
            ans.add(new ArrayList(subset));
        }

        // Now, add everything again to the ans,
        // but this time nums[i] should be appended before
        // adding a subset to the ans.
        for(List<Integer> subset : partialAns) {
            List<Integer> newSubset = new ArrayList(subset);
            newSubset.add(nums[i]);
            ans.add(newSubset);
        }

        return ans;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsetsHelper(nums, nums.length - 1);
    }
}