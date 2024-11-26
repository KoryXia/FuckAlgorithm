/*
 * @lc app=leetcode id=17 lang=golang
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
func letterCombinations(digits string) []string {
	res, path := make([]string, 0), make([]byte, 0)
	m := []string{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

	if digits == "" {
		return res
	}

	var backtracking func(index int)
	backtracking = func(index int) {
		if len(path) == len(digits) {
			tmp := string(path)
			res = append(res, tmp)
			return
		}
		digit := int(digits[index] - '0')
		str := m[digit-2]
		for i := 0; i < len(str); i++ {
			path = append(path, str[i])
			backtracking(index + 1)
			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return res
}

// @lc code=end

