/*
 * @lc app=leetcode id=1 lang=golang
 *
 * [1] Two Sum
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	numsMap := make(map[int]int)

	for i, num := range nums {
		complement := target - num

		if index, ok := numsMap[complement]; ok {
			return []int{index, i}
		}

		numsMap[num] = i
	}
	return nil
}

// @lc code=end

