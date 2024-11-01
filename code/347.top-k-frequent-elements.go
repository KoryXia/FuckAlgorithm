/*
 * @lc app=leetcode id=347 lang=golang
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
func topKFrequent(nums []int, k int) []int {
	res := []int{}
	mapNum := map[int]int{}
	for _, val := range nums {
		mapNum[val]++
	}
	for key, _ := range mapNum {
		res = append(res, key)
	}

	sort.Slice(res, func(a, b int) bool {
		return mapNum[res[a]] > mapNum[res[b]]
	})
	return res[:k]
}

// @lc code=end

