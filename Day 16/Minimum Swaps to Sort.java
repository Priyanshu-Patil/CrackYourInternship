class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        int ans =  0;
        int[] temp = Arrays.copyOfRange(nums, 0, n);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(temp);
        
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] != temp[i]) {
                ans++;
                int init = nums[i];
                
                swap(nums, i, map.get(temp[i]));
                
                map.put(init, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        
        return ans;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}