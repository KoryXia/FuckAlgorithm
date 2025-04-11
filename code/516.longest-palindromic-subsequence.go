/*
 * @lc app=leetcode id=516 lang=golang
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
func longestPalindromeSubseq(s string) int {
	size := len(s)
	dp := make([][]int, size)
	for i := 0; i < size; i++ {
		dp[i] = make([]int, size)
		dp[i][i] = 1
	}
	for i := size - 1; i >= 0; i-- {
		for j := i + 1; j < size; j++ {
			if s[i] == s[j] {
				dp[i][j] = dp[i+1][j-1] + 2
			} else {
				dp[i][j] = max(dp[i][j-1], dp[i+1][j])
			}
		}
	}
	return dp[0][size-1]
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

