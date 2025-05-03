/*
 * @lc app=leetcode id=28 lang=golang
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start
func strStr(haystack string, needle string) int {
	next, j := make([]int, len(needle)), 0
	getPrefix(next, needle)
	for i := 0; i < len(haystack); i++ {
		for j > 0 && haystack[i] != needle[j] {
			j = next[j-1]
		}
		if haystack[i] == needle[j] {
			j++
		}
		if j == len(needle) {
			return i - j + 1
		}
	}
	return -1
}
func getPrefix(next []int, pattern string) {
	j := 0
	next[0] = 0
	for i := 1; i < len(pattern); i++ {
		for j > 0 && pattern[i] != pattern[j] {
			j = next[j-1]
		}
		if pattern[i] == pattern[j] {
			j++
		}
		next[i] = j
	}
}

// @lc code=end

