/*
 * @lc app=leetcode id=459 lang=golang
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
func repeatedSubstringPattern(s string) bool {
	n := len(s)
	next, j := make([]int, n), 0
	next[0] = 0
	for i := 1; i < n; i++ {
		for j > 0 && s[i] != s[j] {
			j = next[j-1]
		}
		if s[i] == s[j] {
			j++
		}
		next[i] = j
	}

	return next[n-1] > 0 && n%(n-next[n-1]) == 0
}

// @lc code=end

