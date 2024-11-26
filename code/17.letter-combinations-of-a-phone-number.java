/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(0, digits, numString);
        return res;
    }

    public void backtracking(int index, String digits, String[] numString) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(index + 1, digits, numString);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

