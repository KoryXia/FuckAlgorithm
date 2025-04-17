/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isAlphabet(s.charAt(i))) {
                count++;
            } else if (count > 0) {
                break;
            }
        }
        return count;
    }

    public boolean isAlphabet(char a) {
        if ((a <= 'z' && a >= 'a') || (a <= 'Z' && a >= 'A')) {
            return true;
        }
        return false;
    }
}
// @lc code=end

