/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtracking("", 0, 0, n);
        return res;
    }

    public void backtracking(String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }
        if (open < max) {
            backtracking(current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtracking(current + ")", open, close + 1, max);
        }
    }
}
// @lc code=end

