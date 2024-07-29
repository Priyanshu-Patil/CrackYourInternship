class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        Arrays.sort(a);
        
        // Sort array b in descending order
        Arrays.sort(b);
        for (int i = 0; i < n / 2; i++) {
            long temp = b[i];
            b[i] = b[n - 1 - i];
            b[n - 1 - i] = temp;
        }
        
        // Check if a[i] + b[i] >= k for all i
        for (int i = 0; i < n; i++) {
            if (a[i] + b[i] < k) {
                return false;
            }
        }
        
        return true;
    }
}