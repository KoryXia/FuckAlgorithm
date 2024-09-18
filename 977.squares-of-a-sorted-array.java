/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start

// import java.util.PriorityQueue;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i--] = nums[left] * nums[left];
                left++;
            } else {
                res[i--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

