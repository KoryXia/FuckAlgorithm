/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // buy state
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            // sell state
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // sell today!
            dp[i][2] = dp[i - 1][0] + prices[i];
            // cooldown
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[prices.length - 1][3], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
// @lc code=end
