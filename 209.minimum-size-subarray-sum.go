/*
 * @lc app=leetcode id=209 lang=golang
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
func minSubArrayLen(target int, nums []int) int {
	left, right, sum, res := 0, 0, 0, math.MaxInt32

	for right < len(nums) {
		sum += nums[right]
		for sum >= target {
			res = min(res, right-left+1)
			sum -= nums[left]
			left++
		}
		right++
	}

	if res == math.MaxInt32 {
		return 0
	} else {
		return res
	}
}

// @lc code=end

