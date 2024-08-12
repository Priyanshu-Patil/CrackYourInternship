class Solution {
    public int[] getPSE(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) result[i] = -1;
            else result[i] = s.peek();

            s.push(i);
        }

        return result;
    }
    
    public int[] getNSE(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) result[i] = n;
            else result[i] = s.peek();

            s.push(i);
        }

        return result;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = getPSE(arr, n);
        int[] nse = getNSE(arr, n);

        long sum = 0;
        long M = 1000000007;

        for (int i = 0; i < n; ++i) {
            long left = i - pse[i];
            long right = nse[i] - i;

            long totalWaysOfMin = left * right;
            long sumofWays = arr[i] * totalWaysOfMin;
            sum = (sum + sumofWays) % M;
        }

        return (int) sum;
    }
}