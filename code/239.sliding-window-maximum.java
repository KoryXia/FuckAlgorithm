/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? b[0] - a[0] : b[1] - a[1];
        });

        for (int i = 0; i < k; i++) {
            queue.add(new int[] { nums[i], i });
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.add(new int[] { nums[i], i });
            while (queue.peek()[1] < i - k + 1) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }
        return res;
    }
}
// @lc code=end
