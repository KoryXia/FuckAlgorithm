/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
    
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        return dp[n];
    }
}
// @lc code=end

