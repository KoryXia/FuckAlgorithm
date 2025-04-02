/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res1 = robAction(nums, 1, nums.length - 1);
        int res2 = robAction(nums, 0, nums.length - 2);
        return Math.max(res1, res2);
    }

    public int robAction(int[] nums, int start, int end) {
        if (end == start ) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
// @lc code=end

