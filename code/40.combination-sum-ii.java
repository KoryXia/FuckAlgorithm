/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(i + 1, sum, target, candidates);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
// @lc code=end

