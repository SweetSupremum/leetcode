package easy;

/**
 * {@see https://leetcode.com/problems/best-time-to-buy-and-sell-stock/}
 *
 * @author SweetSupremum
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPointer = 0;
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[minPointer]) {
                minPointer = i;
            }
            maxDiff = Math.max(maxDiff, prices[i] - prices[minPointer]);
        }

        return maxDiff;
    }


}
