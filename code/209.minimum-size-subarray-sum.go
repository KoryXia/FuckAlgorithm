/*
 * @lc app=leetcode id=209 lang=golang
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
func minSubArrayLen(target int, nums []int) int {
	left, sum, res := 0, 0, len(nums)+1

	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		for sum >= target {
			res = min(res, i-left+1)
			sum -= nums[left]
			left++
		}
	}

	if res == len(nums)+1 {
		return 0
	} else {
		return res
	}
}

// @lc code=end

