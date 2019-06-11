package BestTimetoBuyandSellStock;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
