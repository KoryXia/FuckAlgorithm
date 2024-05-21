/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

//  用 k 记录重复的数量，然后把不是重复的换到前 k 项。
// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
// @lc code=end

