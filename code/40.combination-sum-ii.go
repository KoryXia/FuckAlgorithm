/*
 * @lc app=leetcode id=40 lang=golang
 *
 * [40] Combination Sum II
 */

// @lc code=start
func combinationSum2(candidates []int, target int) [][]int {
	path, res := make([]int, 0), make([][]int, 0)
	sort.Ints(candidates)
	var backtracking func(sum, start int)
	backtracking = func(sum, start int) {
		if sum > target {
			return
		}
		if sum == target {
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
		}

		for i := start; i < len(candidates); i++ {
			if i > start && candidates[i] == candidates[i-1] {
				continue
			}
			path = append(path, candidates[i])
			backtracking(sum+candidates[i], i+1)
			path = path[:len(path)-1]
		}
	}
	backtracking(0, 0)
	return res
}

// @lc code=end

