/*
 * @lc app=leetcode id=134 lang=golang
 *
 * [134] Gas Station
 */

// @lc code=start
func canCompleteCircuit(gas []int, cost []int) int {
	currSum, totalSum, start := 0, 0, 0
	for i := 0; i < len(gas); i++ {
		currSum += gas[i] - cost[i]
		totalSum += gas[i] - cost[i]
		if currSum < 0 {
			start = i + 1
			currSum = 0
		}
	}
	if totalSum < 0 {
		return -1
	}
	return start
}

// @lc code=end

