/*
 * @lc app=leetcode id=452 lang=golang
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] < points[j][0]
	})

	res := 1
	for i := 1; i < len(points); i++ {
		if points[i][0] > points[i-1][1] {
			res++
		} else {
			if points[i-1][1] > points[i][1] {
				points[i][1] = points[i][1]
			} else {
				points[i][1] = points[i-1][1]
			}

		}
	}
	return res
}

// @lc code=end

