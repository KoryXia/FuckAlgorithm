/*
 * @lc app=leetcode id=202 lang=golang
 *
 * [202] Happy Number
 */

// @lc code=start
func isHappy(n int) bool {
	m := make(map[int]bool)
	for n != 1 && !m[n] {
		m[n] = true
		n = next(n)
	}
	return n == 1
}

func next(n int) int {
	sum := 0
	for n > 0 {
		sum += (n % 10) * (n % 10)
		n = n / 10
	}
	return sum
}

// @lc code=end

