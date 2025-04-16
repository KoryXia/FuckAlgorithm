/*
 * @lc app=leetcode id=27 lang=golang
 *
 * [27] Remove Element
 */

// @lc code=start
func removeElement(nums []int, val int) int {
	slow := 0
	for _, v := range nums {
		if v != val {
			nums[slow] = v
			slow++
		}
	}
	return slow
}

// @lc code=end

