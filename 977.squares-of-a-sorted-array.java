/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start

// import java.util.PriorityQueue;

class Solution {
    public int[] sortedSquares(int[] nums) {
        /*
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i] * nums[i]);
        }

        int[] res = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
         */

        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = nums.length - 1;

        while (left <= right) {
            int leftSquare = (int) Math.pow(nums[left], 2);
            int rightSquare = (int) Math.pow(nums[right], 2);

            if (leftSquare > rightSquare) {
                res[i--] = leftSquare;
                left++;
            } else {
                res[i--] = rightSquare;
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

