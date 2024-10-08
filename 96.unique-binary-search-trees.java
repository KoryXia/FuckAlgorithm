/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

0 = 0
1 = 0 * 2
2 = 1 * 1
3 = 2 * 0
dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2];
