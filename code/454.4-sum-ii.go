/*
 * @lc app=leetcode id=454 lang=golang
 *
 * [454] 4Sum II
 */

// @lc code=start
func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) int {
	m, res := make(map[int]int), 0

	for _, v1 := range nums1 {
		for _, v2 := range nums2 {
			m[v1+v2]++
		}
	}

	for _, v3 := range nums3 {
		for _, v4 := range nums4 {
			res += m[-(v3 + v4)]
		}
	}
	return res
}

// @lc code=end

