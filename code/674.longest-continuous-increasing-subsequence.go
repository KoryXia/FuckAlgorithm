/*
 * @lc app=leetcode id=674 lang=golang
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
func findLengthOfLCIS(nums []int) int {
	dp, res := make([]int, len(nums)), 1
	for i := range dp {
		dp[i] = 1
	}
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			dp[i] = max(dp[i], dp[i-1]+1)
		}
		res = max(res, dp[i])
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

