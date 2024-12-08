/*
 * @lc app=leetcode id=376 lang=golang
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
func wiggleMaxLength(nums []int) int {
	if len(nums) == 1 {
		return 1
	}
	prediff, currdiff, res := 0, 0, 1
	for i := 0; i < len(nums)-1; i++ {
		currdiff = nums[i+1] - nums[i]
		if (prediff >= 0 && currdiff < 0) || (prediff <= 0 && currdiff > 0) {
			res++
			prediff = currdiff
		}
	}
	return res
}

// @lc code=end

