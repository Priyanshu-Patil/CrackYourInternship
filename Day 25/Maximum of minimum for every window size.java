class Solution {
    public static int[] findNSE(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, n);

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            
            if (!s.isEmpty()) {
                ans[i] = s.peek();
            }
            
            s.push(i);
        }

        return ans;
    }

    public static int[] findPSE(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            
            if (!s.isEmpty()) {
                ans[i] = s.peek();
            }
            
            s.push(i);
        }

        return ans;
    }
    
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] nse = findNSE(arr, n);
        int[] pse = findPSE(arr, n);
        int[] ans = new int[n + 1];
        Arrays.fill(ans, 0);

        for (int i = 0; i < n; i++) {
            if (nse[i] == -1) {
                nse[i] = n;
            }
            
            int len = nse[i] - pse[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return Arrays.copyOfRange(ans, 1, n + 1);
    }
}