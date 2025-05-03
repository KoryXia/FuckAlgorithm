/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // return (s+s).indexOf(s, 1) != s.length();
        int len = s.length();
        int[] next = new int[len];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next[len - 1] > 0 && len % (len - next[len - 1]) == 0;
    }
}
// @lc code=end
