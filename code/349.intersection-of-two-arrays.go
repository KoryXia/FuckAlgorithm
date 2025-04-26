/*
 * @lc app=leetcode id=349 lang=golang
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
func intersection(nums1 []int, nums2 []int) []int {
	set := make(map[int]bool)
	for _, v := range nums1 {
		set[v] = true
	}

	var res []int

	for _, v := range nums2 {
		if set[v] {
			res = append(res, v)
			delete(set, v)
		}
	}

	return res
}

// @lc code=end

