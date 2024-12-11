/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();

        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);
    }
}
// @lc code=end

