/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1 ;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
// @lc code=end

/**
 * 
 * dp[i]: 第 i 个斐波那契数
 * 递推公式：f(n) = f(n - 1) + f(n -2)
 * 初始化数组： dp[0] = 0, dp[1] = 1
 * 遍历顺序： 从前往后
 * 打印dp数组： debug
 */
