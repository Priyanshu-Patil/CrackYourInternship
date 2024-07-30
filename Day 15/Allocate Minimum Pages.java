class Solution {
    public static boolean isPossible(int n, int[] arr, int m, long currMin) {
        int studentReq = 1;
        long curSum = 0;
        
        for (int i = 0; i < n; ++i) {
            if (arr[i] > currMin) return false;
            
            if (curSum + arr[i] > currMin) {
                studentReq++;
                curSum = arr[i];
                
                if (studentReq > m) return false;
            } else {
                curSum += arr[i];
            }
        }
        
        return true;
    }
    
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        long sum = 0;
        
        if (n < m) return -1;
        
        //counting total no. pages
        
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
        }
        
        // Initializing start as 0 pages and end as total pages.
        long start = 0;
        long end = sum;
        long ans = (long)1e15;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
              // Checking if it is possible to distribute books using mid as the current minimum
            if (isPossible(n, arr, m, mid)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
};