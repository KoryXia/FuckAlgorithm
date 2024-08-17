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
        backTracking(1, 0, k, n);
        return res;
    }

    public void backtracking(int start, int sum, int k, int n) {
        if (sum > n) {
            return;
        }

        if (path.size() > k) {
            return;
        }

        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTracking(i + 1, sum, k, n);
            sum -= i;
            path.removeLast();
        }
    }

}
// @lc code=end

