/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] locngest Palindromic Substring
 */

// @lc code=start
class Solution {
    private int loc, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); 
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(loc, loc + maxLen);
    }

    private void extendPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (maxLen < r - l - 1) {
            loc = l + 1;
            maxLen = r - l - 1;
        }
    }
}
// @lc code=end

