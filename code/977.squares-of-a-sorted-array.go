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
		squareL, squareR := nums[left]*nums[left], nums[right]*nums[right]
		if squareL < squareR {
			res[i] = squareR
			right--
		} else {
			res[i] = squareL
			left++
		}
		i--
	}
	return res
}

// @lc code=end

