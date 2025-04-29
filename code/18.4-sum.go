/*
 * @lc app=leetcode id=18 lang=golang
 *
 * [18] 4Sum
 */

// @lc code=start
func fourSum(nums []int, target int) [][]int {
	res := [][]int{}
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if nums[i] > target && nums[i] >= 0 {
			break
		}

		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] > target && nums[i]+nums[j] >= 0 {
				break
			}

			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}

			left, right := j+1, len(nums)-1
			for left < right {
				sum := nums[i] + nums[j] + nums[left] + nums[right]
				if sum < target {
					left++
				} else if sum > target {
					right--
				} else {
					res = append(res, []int{nums[i], nums[j], nums[left], nums[right]})
					for left < right && nums[left] == nums[left+1] {
						left++
					}
					for left < right && nums[right] == nums[right-1] {
						right--
					}
					left++
					right--
				}
			}
		}
	}
	return res
}

// @lc code=end

