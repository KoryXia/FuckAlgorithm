/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (check(str)){
                path.add(str);
                backtracking(s, i + 1);
                path.removeLast();
            }
        }
    }

    public boolean check(String sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
