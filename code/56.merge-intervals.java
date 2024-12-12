/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (left > end) {
                list.add(new int[] {start, end});
                start = left;
            }

            end = Math.max(end, right);
        }
        
        list.add(new int[] {start, end});
        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end

