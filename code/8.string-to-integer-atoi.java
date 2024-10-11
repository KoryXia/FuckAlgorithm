/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
import static java.lang.Character.isDigit;
class Solution {
    public int myAtoi(String s) {
        int index = 0;
        boolean isNegative = false;
        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                isNegative = true;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }
        int res = 0;
        while (index < s.length() && isDigit(s.charAt(index))) {
            int temp = s.charAt(index) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res = res * 10 + temp;
            index++;
        }
        return isNegative?-res:res;
    }
}
// @lc code=end

