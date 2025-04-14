/*
 * @lc app=leetcode id=496 lang=golang
 *
 * [496] Next Greater Element I
 */

// @lc code=start
func nextGreaterElement(nums1 []int, nums2 []int) []int {
	res := make([]int, len(nums1))
	m := map[int]int{}
	for i, v := range nums1 {
		m[v] = i
		res[i] = -1
	}

	stack := []int{}

	for i, v := range nums2 {
		for len(stack) != 0 && v > nums2[stack[len(stack)-1]] {
			top := nums2[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			if _, ok := m[top]; ok {
				res[m[top]] = v
			}
		}
		stack = append(stack, i)
	}
	return res
}

// @lc code=end

