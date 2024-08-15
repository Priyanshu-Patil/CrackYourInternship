class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int ans = 0;

        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= end) {
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][0] < end) {
                ans++;

                if (intervals[i][1] <= end) {
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }

        return ans;
    }
}