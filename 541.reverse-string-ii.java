/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k, len) - 1;

            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
// @lc code=end

