/*
 * @lc app=leetcode id=84 lang=golang
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
func largestRectangleArea(heights []int) int {
	result := 0
	heights = append([]int{0}, heights...)
	heights = append(heights, 0)
	stack := []int{0}

	for i := 1; i < len(heights); i++ {
		if heights[i] > heights[stack[len(stack)-1]] {
			stack = append(stack, i)
		} else if heights[i] == heights[stack[len(stack)-1]] {
			stack = stack[:len(stack)-1]
			stack = append(stack, i)
		} else {
			for len(stack) > 0 && heights[i] < heights[stack[len(stack)-1]] {
				mid := stack[len(stack)-1]
				stack = stack[:len(stack)-1]
				if len(stack) > 0 {
					left := stack[len(stack)-1]
					right := i
					w := right - left - 1
					h := heights[mid]
					result = max(result, w*h)
				}
			}
			stack = append(stack, i)
		}
	}
	return result
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

// @lc code=end

