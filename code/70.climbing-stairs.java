    /*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // if (n <= 2) {
        //     return n;
        // } 
        // int[] dp = new int[n+1];
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= 2; i++) {
                if (j - i >= 0) dp[j] += dp[j - i];
            }
        }
        return dp[n];
    }
}
// @lc code=end

