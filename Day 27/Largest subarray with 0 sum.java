class GfG {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                ans = Math.max(ans, i - map.get(sum));
            }
            
            if (sum == 0) ans = Math.max(sum, i + 1);
        }
        
        return ans;
    }
}