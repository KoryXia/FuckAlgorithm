/*
 * @lc app=leetcode id=309 lang=golang
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
func maxProfit(prices []int) int {
	dp := make([][]int, len(prices))
	for i := 0; i < len(prices); i++ {
		dp[i] = make([]int, 4)
	}

	dp[0][0] = -prices[0]
	for i := 1; i < len(prices); i++ {
		// buy state
		dp[i][0] = max(dp[i-1][0], max(dp[i-1][1]-prices[i], dp[i-1][3]-prices[i]))
		// sell state
		dp[i][1] = max(dp[i-1][1], dp[i-1][3])
		// sell today!
		dp[i][2] = dp[i-1][0] + prices[i]
		// cooldown
		dp[i][3] = dp[i-1][2]
	}
	return slices.Max(dp[len(prices)-1])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

