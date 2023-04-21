// 122 买卖股票的最佳时机 ||
// 1.动态规划 设置每天两个状态 持有股票和没有持有股票 然后根据前一天递推

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n][2];
        dp[0][0]=0; dp[0][1]=-prices[0];
        for(int i=1;i<n;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}

// 2.直接前一位减去后一位

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for(int i=1;i<n;i++)
        {
            ans+=Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }
}