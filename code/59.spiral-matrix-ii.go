/*
 * @lc app=leetcode id=59 lang=golang
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
func generateMatrix(n int) [][]int {
	startx, starty := 0, 0
	var loop int = n / 2
	var center int = n / 2
	count := 1
	offset := 1
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}
	for loop > 0 {
		i, j := startx, starty

		for j = starty; j < n-offset; j++ {
			res[i][j] = count
			count++
		}

		for i = startx; i < n-offset; i++ {
			res[i][j] = count
			count++
		}

		for ; j > starty; j-- {
			res[i][j] = count
			count++
		}

		for ; i > startx; i-- {
			res[i][j] = count
			count++
		}
		startx++
		starty++
		offset++
		loop--
	}
	if n%2 == 1 {
		res[center][center] = n * n
	}
	return res
}

// @lc code=end

