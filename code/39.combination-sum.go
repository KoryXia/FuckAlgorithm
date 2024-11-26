/*
 * @lc app=leetcode id=39 lang=golang
 *
 * [39] Combination Sum
 */

// @lc code=start
func combinationSum(candidates []int, target int) [][]int {
	res, path := make([][]int, 0), make([]int, 0)
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
			return
		}

		for i := start; i < len(candidates); i++ {
			path = append(path, candidates[i])
			backtracking(sum+candidates[i], i)
			path = path[:len(path)-1]
		}
	}
	backtracking(0, 0)
	return res
}

// @lc code=end

