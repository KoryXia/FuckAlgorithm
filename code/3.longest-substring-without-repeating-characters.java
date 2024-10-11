/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        for(int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if(map.containsKey(current)) {
                left = Math.max(map.get(current) + 1, left);
            }
            len = Math.max(len, right - left + 1);
            map.put(s.charAt(right), right);
        }
        return len;
    }
}
//右指针一直往右，检测hash表中是否存在重复字符，若存在，将左指针指向重复字符后一位。
// @lc code=end

