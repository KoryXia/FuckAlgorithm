/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);   
        }

        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int curr = num;
                while (set.contains(curr + 1)) {
                    count++;
                    curr++;
                }

                res = Math.max(count, res);
            }
        }

        return res;
    }

}
// @lc code=end

