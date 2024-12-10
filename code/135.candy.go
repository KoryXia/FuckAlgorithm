/*
 * @lc app=leetcode id=135 lang=golang
 *
 * [135] Candy
 */

// @lc code=start
func candy(ratings []int) int {
	candy := make([]int, len(ratings))
	sum := 0
	for i := 0; i < len(ratings); i++ {
		candy[i] = 1
	}

	for i := 0; i < len(ratings)-1; i++ {
		if ratings[i] < ratings[i+1] {
			candy[i+1] = candy[i] + 1
		}
	}

	for i := len(ratings) - 1; i > 0; i-- {
		if ratings[i-1] > ratings[i] {
			candy[i-1] = findMax(candy[i-1], candy[i]+1)
		}
	}
	for i := 0; i < len(ratings); i++ {
		sum += candy[i]
	}
	return sum
}

func findMax(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}

// @lc code=end

