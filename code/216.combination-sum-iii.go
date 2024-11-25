/*
 * @lc app=leetcode id=216 lang=golang
 *
 * [216] Combination Sum III
 */

// @lc code=start
func combinationSum3(k int, n int) [][]int {
	path, res := make([]int, 0, k), make([][]int, 0)
	var backtracking func(k, n, sum, start int)
	backtracking = func(k, n, sum, start int) {
		if sum > n {
			return
		}

		if len(path) > k {
			return
		}

		if sum == n && len(path) == k {
			tmp := make([]int, k)
			copy(tmp, path)
			res = append(res, tmp)
			return
		}

		for i := start; i <= 9; i++ {
			path = append(path, i)
			backtracking(k, n, sum+i, i+1)
			path = path[:len(path)-1]
		}
	}
	backtracking(k, n, 0, 1)
	return res
}

// @lc code=end

