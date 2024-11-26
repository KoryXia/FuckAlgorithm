/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(0, 0, target, candidates);
        return res;
    }

    public void backtracking(int start, int sum, int target, int[] candidates) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(i, sum + candidates[i], target, candidates);
            path.removeLast();
        }
    }
}
// @lc code=end

