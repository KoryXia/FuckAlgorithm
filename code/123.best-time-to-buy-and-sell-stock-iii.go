/*
 * @lc app=leetcode id=123 lang=golang
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}
	dp := make([]int, 5)
	dp[1] = -prices[0]
	dp[3] = -prices[0]
	for i := 1; i < len(prices); i++ {
		dp[1] = max(dp[1], dp[0]-prices[i])
		dp[2] = max(dp[2], dp[1]+prices[i])
		dp[3] = max(dp[3], dp[2]-prices[i])
		dp[4] = max(dp[4], dp[3]+prices[i])
	}
	return dp[4]
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

// @lc code=end

