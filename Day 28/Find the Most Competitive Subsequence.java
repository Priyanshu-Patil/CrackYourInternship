class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < nums.length; ++i) {
            while (!s.isEmpty() && nums[i] < s.peek() && nums.length - i > k - s.size()) {
                s.pop();
            }
            
            if (s.size() < k) {
                s.push(nums[i]);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }
}