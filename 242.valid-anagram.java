/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            
        }

        for (char c : t.toCharArray()) {
            if (map.get(c) == null || map.get(c) == 0) {
                return false;
            }
            
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
// @lc code=end

