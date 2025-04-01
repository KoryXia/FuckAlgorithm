/*
 * @lc app=leetcode id=139 lang=golang
 *
 * [139] Word Break
 */

// @lc code=start
func wordBreak(s string, wordDict []string) bool {
	dp := make([]bool, len(s)+1)

	dp[0] = true

	for i := 1; i <= len(s); i++ {
		for _, v := range wordDict {
			length := len(v)
			if i >= length && dp[i-length] && s[i-length:i] == v {
				dp[i] = true
				break
			}
		}
	}
	return dp[len(s)]
}

// @lc code=end

