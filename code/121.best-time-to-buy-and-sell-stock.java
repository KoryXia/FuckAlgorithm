/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            // ith day maximum profit with stock， not buy or buy
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            // ith day maximum profit without stock， not sell or sell
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        // last day sell stock, maximun profit
        return dp[prices.length - 1][1];
    }
}
// @lc code=end

