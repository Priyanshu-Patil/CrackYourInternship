class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minVal = prices[0];

        for (int i = 1; i < n; ++i) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minVal);
            }
        }

        return maxProfit;
    }
}