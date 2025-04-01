/*
 * @lc app=leetcode id=377 lang=golang
 *
 * [377] Combination Sum IV
 */

// @lc code=start
func combinationSum4(nums []int, target int) int {
	dp := make([]int, target+1)
	dp[0] = 1
	for j := 1; j <= target; j++ {
		for i := 0; i < len(nums); i++ {
			if j-nums[i] >= 0 {
				dp[j] += dp[j-nums[i]]
			}
		}
	}
	return dp[target]
}

// @lc code=end

