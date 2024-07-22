/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        StringBuffer res = new StringBuffer();
        int curr = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr >= 0 && res.charAt(curr) == c) {
                res.deleteCharAt(curr);
                curr--;
            } else {
                res.append(c);
                curr++;
            }
        }
        return res.toString();
    }
}
// @lc code=end

