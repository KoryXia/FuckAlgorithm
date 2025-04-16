/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
// @lc code=end

