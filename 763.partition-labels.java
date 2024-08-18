/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {;
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
// @lc code=end

