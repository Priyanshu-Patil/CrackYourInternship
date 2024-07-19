class Solution {
    public int majorityElement(int[] nums) {
        // Moore's Voting Algorithm
        int candidate = nums[0];
        int count = 0;

        for (int num: nums) {
            if (num == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = num;
                    count++;
                }
            }
        }

        return candidate;
    }
}