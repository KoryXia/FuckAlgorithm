/*
 * @lc app=leetcode id=541 lang=golang
 *
 * [541] Reverse String II
 */

// @lc code=start
func reverseStr(s string, k int) string {
	ss := []byte(s)
	for i := 0; i < len(ss); i += 2 * k {
		left := i
		right := min(left+k-1, len(ss)-1)
		for left < right {
			ss[left], ss[right] = ss[right], ss[left]
			left++
			right--
		}
	}
	return string(ss)
}

// @lc code=end

