/*
 * @lc app=leetcode id=518 lang=golang
 *
 * [518] Coin Change II
 */

// @lc code=start
func change(amount int, coins []int) int {
	dp := make([]int, amount+1)
	dp[0] = 1

	for i := 0; i < len(coins); i++ {
		for j := coins[i]; j <= amount; j++ {
			dp[j] += dp[j-coins[i]]
		}
	}

	return dp[amount]
}

// @lc code=end

