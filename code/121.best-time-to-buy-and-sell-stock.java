/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            res = Math.max(res, prices[i] - lowest);
        }
        return res;
    }
}
// @lc code=end

