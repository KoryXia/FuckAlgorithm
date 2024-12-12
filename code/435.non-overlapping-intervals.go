/*
 * @lc app=leetcode id=435 lang=golang
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	res := 1

	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] >= intervals[i-1][1] {
			res++
		} else {
			intervals[i][1] = min(intervals[i-1][1], intervals[i][1])
		}
	}
	return len(intervals) - res
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

// @lc code=end

