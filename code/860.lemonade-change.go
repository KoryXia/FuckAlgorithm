/*
 * @lc app=leetcode id=860 lang=golang
 *
 * [860] Lemonade Change
 */

// @lc code=start
func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for i := 0; i < len(bills); i++ {
		if bills[i] == 5 {
			five++
		}

		if bills[i] == 10 {
			if five == 0 {
				return false
			}
			ten++
			five--
		}

		if bills[i] == 20 {
			if five >= 1 && ten >= 1 {
				ten--
				five--
			} else if five >= 3 {
				five -= 3
			} else {
				return false
			}
		}
	}
	return true
}

// @lc code=end

