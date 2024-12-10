/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 */

// @lc code=start

import java.util.stream.IntStream;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int K) {
        nums = IntStream
        .of(nums)
        .boxed()
        .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
        .mapToInt(Integer::intValue)
        .toArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }

        if (K % 2 == 1) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }

        return IntStream.of(nums).sum();
    }
}
// @lc code=end

