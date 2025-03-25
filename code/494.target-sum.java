/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int space = (sum + target) / 2;
        int[] dp = new int[space + 1];

        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = space; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[space];
    }
}
// @lc code=end
