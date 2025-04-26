/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }

        Set<Integer> res = new HashSet<>();
        for (int num: nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
