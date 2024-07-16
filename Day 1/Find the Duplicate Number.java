//Approach 1
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}



//Approach 2
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int index = Math.abs(nums[i]);

            if (nums[index] < 0) {
                return index;
            }

            nums[index] = -nums[index];
        }

        return -1;
    }
}
