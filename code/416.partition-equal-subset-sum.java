/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int space = sum / 2;
        int[] dp = new int[space + 1];
        for (int i = 0; i < n; i++) {
            for (int j = space; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            if (dp[space] == space) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
