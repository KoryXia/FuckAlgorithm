/*
 * @lc app=leetcode id=202 lang=golang
 *
 * [202] Happy Number
 */

// @lc code=start
func isHappy(n int) bool {
	slow := n
	fast := next(n)
	for fast != 1 && slow != fast {
		slow = next(slow)
		fast = next(next(fast))
	}
	return fast == 1
}

func next(n int) int {
	sum := 0

	for n > 0 {
		sum += (n % 10) * (n % 10)
		n /= 10
	}
	return sum
}

// @lc code=end

