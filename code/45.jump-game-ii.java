/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int currCover = 0;
        int maxCover = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCover = Math.max(i + nums[i], maxCover);
            if (maxCover >= nums.length - 1) {
                res++;
                break;
            }

            if (i == currCover) {
                currCover = maxCover;
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

