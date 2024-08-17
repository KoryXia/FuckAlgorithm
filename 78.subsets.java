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
        backTracking(0, nums);
        return res;
    }

    public void backTracking(int i, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backTracking(j + 1, nums);
            path.removeLast();
        }
    }
}
// @lc code=end

123

  1   2   3 
 2 3 3  
3