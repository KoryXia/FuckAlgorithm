/*
 * @lc app=leetcode id=93 lang=golang
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
func restoreIpAddresses(s string) []string {
	path, res := make([]string, 0), make([]string, 0)
	var backtracking func(start int)
	backtracking = func(start int) {
		if len(path) == 4 && start == len(s) {
			str := strings.Join(path, ".")
			res = append(res, str)
			return
		}

		for i := start; i <= start+3 && i < len(s); i++ {
			if i != start && s[start] == '0' {
				break
			}

			str := s[start : i+1]
			num, _ := strconv.Atoi(str)
			if num >= 0 && num < 256 {
				path = append(path, str)
				backtracking(i + 1)
				path = path[:len(path)-1]
			} else {
				break
			}
		}
	}
	backtracking(0)
	return res
}

// @lc code=end

