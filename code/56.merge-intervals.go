/*
 * @lc app=leetcode id=56 lang=golang
 *
 * [56] Merge Intervals
 */

// @lc code=start
func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	res, start, end := make([][]int, 0), intervals[0][0], intervals[0][1]

	for i := 0; i < len(intervals); i++ {
		left, right := intervals[i][0], intervals[i][1]
		if left > end {
			res = append(res, []int{start, end})
			start = left
		}

		end = max(end, right)
	}
	res = append(res, []int{start, end})
	return res
}

func max(a, b int) int {
	if a < b {
		a = b
	}
	return a
}

// @lc code=end

