/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    public void backtracking(int k, int n, int start, int sum) {
        if (sum > n) {
            return;
        }
        if (path.size() > k) {
            return;
        }

        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtracking(k, n, i + 1, sum + i);
            path.removeLast();
        }
    }
}
// @lc code=end

