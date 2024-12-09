/*
 * @lc app=leetcode id=45 lang=golang
 *
 * [45] Jump Game II
 */

// @lc code=start
func jump(nums []int) int {
	if nums == nil || len(nums) == 0 || len(nums) == 1 {
		return 0
	}

	res, maxCover, currCover := 0, 0, 0
	for i := 0; i < len(nums); i++ {
		if (i + nums[i]) > maxCover {
			maxCover = i + nums[i]
		}

		if maxCover >= (len(nums) - 1) {
			res++
			break
		}

		if i == currCover {
			currCover = maxCover
			res++
		}
	}
	return res
}

// @lc code=end

