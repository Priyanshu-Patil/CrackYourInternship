class Solution {
    int[] prevSmaller (int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }

        return ans;
    }

    int[] nextSmaller (int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }
        
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] prev = prevSmaller(heights);
        int[] next = nextSmaller(heights);

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; ++i) {
            ans = Math.max(ans, (next[i] - prev[i] - 1) * heights[i]);
        }

        return ans;
    }
}