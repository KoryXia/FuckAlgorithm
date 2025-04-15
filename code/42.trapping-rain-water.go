/*
 * @lc app=leetcode id=42 lang=golang
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
func trap(height []int) int {
	stack := []int{0}
	res := 0
	for i, v := range height {
		if v < height[stack[len(stack)-1]] {
			stack = append(stack, i)
		} else if v == height[stack[len(stack)-1]] {
			stack = stack[:len(stack)-1]
			stack = append(stack, i)
		} else {
			for len(stack) != 0 && v > height[stack[len(stack)-1]] {
				mid := stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				if len(stack) != 0 {
					left := stack[len(stack)-1]
					h, w := min(height[left], v)-height[mid], i-left-1
					res += h * w
				}
			}
			stack = append(stack, i)
		}
	}
	return res
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

// @lc code=end

