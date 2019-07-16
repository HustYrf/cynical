package BestTime2BuyAndSellStockwithTransactionFee;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000
 */
//套用状态转移方程：dp[d][k][i] ,其中d表示交易的天数，k表示交易的次数，i表示是否持有，其中i=0，表示没有持有，i=1表示现在持有股票
// dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])   第i天卖了股票
// dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]) 第i天买了股票,买的时候k-1
//本次题目的特点是，不限制交易次数，所以交易次数k为无穷大，因而k = k-1
//最后的状态转移方程为：
//dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i]-free)
//dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
public class BestTime2BuyAndSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) return 0;
        int max = 0;
        int min = -prices[0];
        int temp;
        for (int i = 1; i < len; i++) {
            temp = max;
            max = Math.max(max, min + prices[i] - fee);
            min = Math.max(min, temp - prices[i]);
        }
        return max;
    }
}
