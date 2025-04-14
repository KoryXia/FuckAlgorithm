/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * size; i++) {
            while (!stack.isEmpty() && nums[i % size] > nums[stack.peek()]) {
                int top = stack.pop();
                res[top] = nums[i % size];
            }
            stack.push(i % size);
        }
        return res;
    }
}
// @lc code=end
