/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
// @lc code=end
