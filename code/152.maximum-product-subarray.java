/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        int maxEndHere = nums[0];
        int minEndHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int temp = maxEndHere;
                maxEndHere = minEndHere;
                minEndHere = temp;
            }
            maxEndHere = Math.max(num, num * maxEndHere);
            minEndHere = Math.min(num, num * minEndHere);

            res = Math.max(res, maxEndHere);
        }

        return res;
    }
}
// @lc code=end

