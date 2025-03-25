/*
 * @lc app=leetcode id=474 lang=golang
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
func findMaxForm(strs []string, m int, n int) int {
	dp := make([][]int, m+1)
	for i, _ := range dp {
		dp[i] = make([]int, n+1)
	}

	for i := 0; i < len(strs); i++ {
		zeroNum, oneNum := 0, 0
		for _, v := range strs[i] {
			if v == '0' {
				zeroNum++
			} else {
				oneNum++
			}
		}

		for j := m; j >= zeroNum; j-- {
			for k := n; k >= oneNum; k-- {
				dp[j][k] = max(dp[j][k], dp[j-zeroNum][k-oneNum]+1)
			}
		}
	}
	return dp[m][n]
}

// @lc code=end

