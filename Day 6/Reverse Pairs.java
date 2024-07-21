class Solution {
    public static void merge(int[] nums, int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = start;      
        int right = mid + 1;   
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= end) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp.get(i - start);
        }
    }

    public static int countPairs(int[] nums, int start, int mid, int end) {
        int right = mid + 1;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (right <= end && nums[i] > 2 * (long) nums[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start >= end) return count;
        int mid = (start + end) / 2;
        count += mergeSort(nums, start, mid);  
        count += mergeSort(nums, mid + 1, end);
        count += countPairs(nums, start, mid, end); 
        merge(nums, start, mid, end); 
        return count;
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
