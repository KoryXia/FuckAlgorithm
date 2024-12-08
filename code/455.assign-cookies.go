/*
 * @lc app=leetcode id=455 lang=golang
 *
 * [455] Assign Cookies
 */

// @lc code=start
func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	cookieIndex, res := len(s)-1, 0
	for i := len(g) - 1; i >= 0 && cookieIndex >= 0; i-- {
		if g[i] <= s[cookieIndex] {
			cookieIndex--
			res++
		}
	}
	return res
}

// @lc code=end

