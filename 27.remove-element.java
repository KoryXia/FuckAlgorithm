/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

//  用 k 记录重复的数量，然后把不是重复的换到前 k 项。
// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
// @lc code=end

