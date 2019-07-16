package BestTime2BuyAndSellStockII;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

//套用状态转移方程：dp[d][k][i] ,其中d表示交易的天数，k表示交易的次数，i表示是否持有，其中i=0，表示没有持有，i=1表示现在持有股票
// dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])   第i天卖了股票
// dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]) 第i天买了股票,买的时候k-1
//本次题目的特点是，不限制交易次数，所以交易次数k为无穷大，因而k = k-1
//最后的状态转移方程为：
//dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
//dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
public class BestTime2BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int max = 0;
        int min = -prices[0];
        int temp;
        for (int i = 1; i < len; i++) {
            temp = max;
            max = Math.max(max, min + prices[i]);
            min = Math.max(min, temp - prices[i]);
        }
        return max;
    }
}
