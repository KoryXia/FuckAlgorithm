/*
 * @lc app=leetcode id=1 lang=golang
 *
 * [1] Two Sum
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)

	for i, v := range nums {
		temp := target - v
		if _, ok := m[temp]; ok {
			return []int{m[temp], i}
		}
		m[nums[i]] = i
	}
	return nil
}

// @lc code=end

