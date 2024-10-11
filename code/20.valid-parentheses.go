/*
 * @lc app=leetcode id=20 lang=golang
 *
 * [20] Valid Parentheses
 */

// @lc code=start
func isValid(s string) bool {
	stack := make([]rune, 0)

	m := make(map[rune]rune)
	m[')'] = '('
	m[']'] = '['
	m['}'] = '{'

	for _, c := range s {
		if c == '(' || c == '[' || c == '{' {
			stack = append(stack, c)
		} else {
			if len(stack) == 0 {
				return false
			}
			peek := stack[len(stack)-1]
			if peek != m[c] {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0
}

// @lc code=end

