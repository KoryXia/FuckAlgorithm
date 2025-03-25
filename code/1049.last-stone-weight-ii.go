/*
 * @lc app=leetcode id=1049 lang=golang
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
func lastStoneWeightII(stones []int) int {
	sum := 0
	for _, stone := range stones {
		sum += stone
	}

	space := sum / 2
	dp := make([]int, space+1)

	for _, stone := range stones {
		for j := space; j >= stone; j-- {
			dp[j] = max(dp[j], dp[j-stone]+stone)
		}
	}

	return sum - 2*dp[space]
}

// @lc code=end

