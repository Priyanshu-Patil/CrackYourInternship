class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        int n = nums.length;
        int i, j;

        int currlen;
        int cost;
        int dp[] = new int[n];
        int ans[] = new int[n];

        dp[n - 1] = 0;
        ans[n - 1] = n - 1;

    for (i = n - 2; i >= 0; i--) 
    {
        currlen = -1;
        dp[i] = Integer.MAX_VALUE;


        for (j = i; j < n; j++) 
        {

            currlen += (nums[j] + 1);


            if (currlen > k)
                break;


            if (j == n - 1)
                cost = 0;
            else
                cost = (k - currlen) * 
                       (k - currlen) +
                            dp[j + 1];


            if (cost < dp[i]) 
            {
                dp[i] = cost;
                ans[i] = j;
            }
        }
       }
       int res = 0;
        i = 0;
        while (i < n) {
            int pos = 0;
            for (j = i; j < ans[i] + 1; j++) {
                pos += nums[j];
            }
            int x = ans[i]-i;
            if(ans[i]+1 != n)
                res += (k - x - pos)*(k - x - pos);
            i = ans[i] + 1;
        }
        return res;
    }
}