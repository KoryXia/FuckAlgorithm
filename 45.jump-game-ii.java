/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int curr = 0;
        int res = 0;
        int distance = 0;
        for (int i = 0; i <= nums.length; i++) {
            distance = Math.max(i + nums[i], distance);
            if (i == curr) {
                res++;
                curr = distance;
                if (distance >= nums.length - 1) {
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

