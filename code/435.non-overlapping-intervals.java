/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                res++;
            } else {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return intervals.length - res;
    }
}
// @lc code=end

