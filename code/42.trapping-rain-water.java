/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int sum = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.getFirst()]) {
                stack.addFirst(i);
            } else {
                while (!stack.isEmpty() && height[stack.getFirst()] < height[i]) {
                    int bottom = stack.removeFirst();
                    if (!stack.isEmpty()) {
                        int left = stack.getFirst();
                        sum += (Math.min(height[left], height[i]) - height[bottom]) * (i - left - 1);
                    }
                }
                stack.addFirst(i);
            }
        }
        return sum;
    }
}
// @lc code=end

