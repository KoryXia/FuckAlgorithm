/*
 * @lc app=leetcode id=704 lang=golang
 *
 * [704] Binary Search
 */

// @lc code=start
func search(nums []int, target int) int {
	left := 0
	right := len(nums)

	for left < right {
		mid := left + (right-left)/2

		if nums[mid] > target {
			right = mid
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			return mid
		}
	}
	return -1
}

// @lc code=end

