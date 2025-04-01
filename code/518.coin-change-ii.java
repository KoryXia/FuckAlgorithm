/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // int[][] dp = new int[coins.length][amount + 1];
        // for (int i = 0; i < coins.length; i++) {
        //     dp[i][0] = 1;
        // }

        // for (int j = 0; j < amount + 1; j++) {
        //     if (j % coins[0] == 0)
        //         dp[0][j] = 1;
        // }

        // for (int i = 1; i < coins.length; i++) {
        //     for (int j = 0; j < amount + 1; j++) {
        //         if (coins[i] > j)
        //             dp[i][j] = dp[i - 1][j];
        //         else
        //             dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
        //     }
        // }
        // return dp[coins.length - 1][amount];
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
// @lc code=end
