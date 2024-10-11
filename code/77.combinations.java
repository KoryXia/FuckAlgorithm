/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
// @lc code=end

