/*
 * @lc app=leetcode id=151 lang=golang
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
func reverseWords(s string) string {
	b := []byte(s)

	slow := 0
	for i := 0; i < len(b); i++ {
		if b[i] != ' ' {
			if slow != 0 {
				b[slow] = ' '
				slow++
			}
			for i < len(b) && b[i] != ' ' {
				b[slow] = b[i]
				slow++
				i++
			}
		}
	}
	b = b[0:slow]

	reverse(b)

	last := 0
	for i := 0; i <= len(b); i++ {
		if i == len(b) || b[i] == ' ' {
			reverse(b[last:i])
			last = i + 1
		}
	}
	return string(b)
}

func reverse(b []byte) {
	left := 0
	right := len(b) - 1
	for left < right {
		b[left], b[right] = b[right], b[left]
		left++
		right--
	}
}

// @lc code=end

