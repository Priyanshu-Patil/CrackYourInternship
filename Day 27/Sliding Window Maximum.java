class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int ansId = 0;

        for (int i = 0; i < n; ++i) {
            while(q.size() > 0 && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);

            if (q.getFirst() <= i - k) {
                q.removeFirst();
            }

            if (i >= k - 1) {
                ans[ansId] = nums[q.getFirst()];
                ansId++;
            }
        }

        return ans;
    }
}