/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, sc.length - 1);
            while (left < right) {
                char temp = sc[left];
                sc[left] = sc[right];
                sc[right] = temp;
                left++;
                right--;
            }
        }
        return new String(sc);
    }
}
// @lc code=end
