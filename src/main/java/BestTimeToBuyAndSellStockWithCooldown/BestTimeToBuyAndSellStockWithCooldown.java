package BestTimeToBuyAndSellStockWithCooldown;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

//套用状态转移方程：dp[d][k][i] ,其中d表示交易的天数，k表示交易的次数，i表示是否持有，其中i=0，表示没有持有，i=1表示现在持有股票
// dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])   第i天卖了股票
// dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]) 第i天买了股票
//本次题目的特点是，有一个冷冻期，卖了之后的后一天不能直接买，并且不限制交易次数，所以交易次数k为无穷大，因而k = k-1
// dp[i][k][1] = max(dp[i-1][k][1],dp[i-2][k-1][0]-prices[i]) //也就是前两天卖了，今天才能买
//最后的状态转移方程为：
//dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
//dp[i][1] = max(dp[i-1][1],dp[i-2][0]-prices[i])
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);   //此处可以优化空间，可是老子不想优化
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
