class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int mid = n%2 == 0 ? (nums[n/2] + nums[n/2 - 1])/2 : nums[n/2];
        int steps = 0;

        for (int num: nums) {
            steps += Math.abs(num - mid);
        }

        return steps;
    }
}