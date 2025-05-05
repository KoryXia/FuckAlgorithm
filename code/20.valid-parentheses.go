/*
 * @lc app=leetcode id=20 lang=golang
 *
 * [20] Valid Parentheses
 */

// @lc code=start
func isValid(s string) bool {
	var stack []rune
	for _, c := range s {
		if c == '(' || c == '[' || c == '{' {
			stack = append(stack, c)
		} else {
			if len(stack) == 0 {
				return false
			}
			prev := stack[len(stack)-1]
			if prev == '(' && c == ')' {
				stack = stack[:len(stack)-1]
			} else if prev == '[' && c == ']' {
				stack = stack[:len(stack)-1]
			} else if prev == '{' && c == '}' {
				stack = stack[:len(stack)-1]
			} else {
				return false
			}
		}
	}
	return len(stack) == 0
}

// @lc code=end

