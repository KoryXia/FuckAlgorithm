/*
 * @lc app=leetcode id=494 lang=golang
 *
 * [494] Target Sum
 */

// @lc code=start
func findTargetSumWays(nums []int, target int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}

	if abs(target) > sum {
		return 0
	}
	if (target+sum)%2 == 1 {
		return 0
	}

	space := (target + sum) / 2
	dp := make([]int, space+1)
	dp[0] = 1
	for _, num := range nums {
		for j := space; j >= num; j-- {
			dp[j] += dp[j-num]
		}
	}
	return dp[space]
}

func abs(x int) int {
	return int(math.Abs(float64(x)))
}

// @lc code=end

