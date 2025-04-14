/*
 * @lc app=leetcode id=503 lang=golang
 *
 * [503] Next Greater Element II
 */

// @lc code=start
func nextGreaterElements(nums []int) []int {
	size := len(nums)
	res := make([]int, size)
	stack := []int{}
	for i, _ := range nums {
		res[i] = -1
	}
	for i := 0; i < 2*size; i++ {
		for len(stack) != 0 && nums[i%size] > nums[stack[len(stack)-1]] {
			top := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			res[top] = nums[i%size]
		}
		stack = append(stack, i%size)
	}
	return res
}

// @lc code=end

