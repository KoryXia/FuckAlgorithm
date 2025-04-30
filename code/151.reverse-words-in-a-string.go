/*
 * @lc app=leetcode id=151 lang=golang
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
func reverseWords(s string) string {
	b := []byte(s)
	var res []byte
	l, r := 0, len(b)-1
	for b[l] == ' ' {
		l++
	}
	for b[r] == ' ' {
		r--
	}
	for i := l; i <= r; i++ {
		if b[i] != ' ' || res[len(res)-1] != ' ' {
			res = append(res, b[i])
		}
	}

	reverse(res)

	l, r = 0, 1

	for l < len(res) {
		for r < len(res) && res[r] != ' ' {
			r++
		}
		reverse(res[l:r])
		l = r + 1
		r = l + 1
	}
	return string(res)
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

