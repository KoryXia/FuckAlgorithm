/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums);
        return res;
    }

    public void backtracking(int start, int[] nums) {
        res.add(new ArrayList<>(path));

        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i + 1, nums);
            path.removeLast();
        }
    }
}
// @lc code=end