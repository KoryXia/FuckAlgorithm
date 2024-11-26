/*
 * @lc app=leetcode id=131 lang=golang
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
func partition(s string) [][]string {
	path, res := make([]string, 0), make([][]string, 0)
	var backtracking func(start int)
	backtracking = func(start int) {
		if start == len(s) {
			tmp := make([]string, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}

		for i := start; i < len(s); i++ {
			str := s[start : i+1]
			if isPalindrome(str) {
				path = append(path, str)
				backtracking(i + 1)
				path = path[:len(path)-1]
			}
		}
	}
	backtracking(0)
	return res
}
func isPalindrome(s string) bool {
	for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
		if s[i] != s[j] {
			return false
		}
	}
	return true
}

// @lc code=end

