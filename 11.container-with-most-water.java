/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
// @lc code=end

