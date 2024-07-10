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
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for (int i: nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] resArray = new int[res.size()];
        int index = 0;
        for (int i : res) {
            resArray[index] = i;
            index++;
        }
        return resArray;
    }
}
// @lc code=end
