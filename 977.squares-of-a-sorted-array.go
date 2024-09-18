/*
 * @lc app=leetcode id=977 lang=golang
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
func sortedSquares(nums []int) []int {
	left, right, i := 0, len(nums)-1, len(nums)-1
	res := make([]int, len(nums))

	for left <= right {
		squareLeft, squareRight := nums[left]*nums[left], nums[right]*nums[right]
		if squareLeft > squareRight {
			res[i] = squareLeft
			left++
		} else {
			res[i] = squareRight
			right--
		}
		i--
	}
	return res
}

// @lc code=end

