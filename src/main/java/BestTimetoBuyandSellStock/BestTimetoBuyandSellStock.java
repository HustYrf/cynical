package BestTimetoBuyandSellStock;

// dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])   第i天卖了股票
// dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]) 第i天买了股票
// k = 1 只能交易一次
//因为只能交易一次，所以在第i天有买了股票之前的天数里是不能买股票的，所有最大收益是就是0，因此dp[i-1][k-1][0] = 0;
//消掉次数k，公式如下
//dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
//dp[i][1] = max(dp[i-1][1],-prices[i])
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = 0;
        int min = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, min + prices[i]);
            min = Math.max(min, -prices[i]);
        }
        return max;
    }
}
