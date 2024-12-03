/*
 * @lc app=leetcode id=47 lang=golang
 *
 * [47] Permutations II
 */

// @lc code=start
func permuteUnique(nums []int) [][]int {
	path, res := make([]int, 0), make([][]int, 0)
	used := make([]bool, len(nums))
	var backtracking func()
	backtracking = func() {
		if len(path) == len(nums) {
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
			return
		}

		for i := 0; i < len(nums); i++ {
			if i > 0 && nums[i-1] == nums[i] && !used[i-1] {
				continue
			}
			if !used[i] {
				used[i] = true
				path = append(path, nums[i])
				backtracking()
				path = path[:len(path)-1]
				used[i] = false
			}
		}
	}
	backtracking()
	return res
}

// @lc code=end

