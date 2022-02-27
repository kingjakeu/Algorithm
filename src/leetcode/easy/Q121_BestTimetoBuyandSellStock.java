package leetcode.easy;

public class Q121_BestTimetoBuyandSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int profit = 0;
            int length = prices.length;
            for (int i = 1; i < length; i++) {
                profit = Math.max(profit, prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return profit;
        }
    }
}
