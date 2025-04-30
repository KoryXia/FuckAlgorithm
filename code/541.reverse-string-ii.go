/*
 * @lc app=leetcode id=541 lang=golang
 *
 * [541] Reverse String II
 */

// @lc code=start
func reverseStr(s string, k int) string {
	bs := []byte(s)
	for i := 0; i < len(bs); i += 2 * k {
		left, right := i, min(i+k-1, len(bs)-1)
		for left < right {
			bs[left], bs[right] = bs[right], bs[left]
			left++
			right--
		}
	}
	return string(bs)
}

// @lc code=end

