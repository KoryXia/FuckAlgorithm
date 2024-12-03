/*
 * @lc app=leetcode id=491 lang=golang
 *
 * [491] Non-decreasing Subsequences
 */

// @lc code=start
func findSubsequences(nums []int) [][]int {
	res, path := make([][]int, 0), make([]int, 0)
	var backtracking func(start int)
	backtracking = func(start int) {
		if len(path) >= 2 {
			tmp := make([]int, len(path))
			copy(tmp, path)
			res = append(res, tmp)
		}

		hs := make(map[int]bool, len(nums))
		for i := start; i < len(nums); i++ {
			if len(path) != 0 && path[len(path)-1] > nums[i] || hs[nums[i]] {
				continue
			}

			hs[nums[i]] = true
			path = append(path, nums[i])
			backtracking(i + 1)
			path = path[:len(path)-1]
		}
	}
	backtracking(0)
	return res
}

// @lc code=end

