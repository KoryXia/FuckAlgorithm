/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int prediff = 0;
        int currdiff = 0;
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            currdiff = nums[i + 1] - nums[i];
            if ((prediff >= 0 && currdiff < 0) || (prediff <= 0 && currdiff > 0)) {
                res++;
                prediff = currdiff;
            }
        }
        return res;
    }
}
// @lc code=end

