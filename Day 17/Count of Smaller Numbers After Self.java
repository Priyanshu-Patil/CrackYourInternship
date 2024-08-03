class Solution {
    public int findInsertPosition(List<Integer> series, int target) {
        int start = 0;
        int end = series.size();

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (series.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> series = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = findInsertPosition(series, nums[i]);
            series.add(pos, nums[i]);
            ans.add(pos);
        }

        Collections.reverse(ans);

        return ans;
    }
}