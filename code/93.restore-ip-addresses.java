/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return  res;

    }

    public void backtracking(StringBuilder sb, int startIndex, int count) {
        if (count == 3 && check(sb, startIndex, sb.length() - 1)) {
            res.add(sb.toString());
            return;
        }

        for (int i = startIndex; i <= startIndex + 3 && i < sb.length(); i++) {
            if (check(sb, startIndex, i)) {
                sb.insert(i + 1, ".");
                backtracking(sb, i + 2, count + 1);
                sb.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    public boolean check(StringBuilder s, int start, int end) {
        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(end)> '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
