/*
 * @lc app=leetcode id=416 lang=golang
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
func canPartition(nums []int) bool {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	if sum%2 == 1 {
		return false
	}

	space := sum / 2
	dp := make([]int, space+1)
	for _, num := range nums {
		for j := space; j >= num; j-- {
			dp[j] = max(dp[j], dp[j-num]+num)
		}

		if dp[space] == space {
			return true
		}
	}
	return false
}

// @lc code=end

