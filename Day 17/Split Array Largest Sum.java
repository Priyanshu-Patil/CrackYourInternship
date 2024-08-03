class Solution {
    public int splitArray(int[] nums, int k) {
        int start = nums[0];
        int end = 0;

        //find max and sum 
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int partitions = countPartitions(nums, mid);
            if (partitions <= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public int countPartitions(int[] nums, int maxSum) {
        int n = nums.length;
        int partitions = 1;
        long subarraySum = 0;
        
        for (int i = 0; i < n; i++) {
            if (subarraySum + nums[i] > maxSum) {
                partitions++;
                subarraySum = nums[i];
            } else {
                subarraySum += nums[i];
                
            }
        }
        
        return partitions;
    }
}