/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int K) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;	    
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }

        if (K % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();

    }
}
// @lc code=end

