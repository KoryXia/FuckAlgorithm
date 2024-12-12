/*
 * @lc app=leetcode id=763 lang=golang
 *
 * [763] Partition Labels
 */

// @lc code=start
func partitionLabels(s string) []int {
	var marks [26]int

	for i := 0; i < len(s); i++ {
		marks[s[i]-'a'] = i
	}

	res := make([]int, 0)
	start, end := 0, 0

	for i := 0; i < len(s); i++ {
		end = max(end, marks[s[i]-'a'])
		if i == end {
			res = append(res, end-start+1)
			start = end + 1
		}
	}
	return res
}

func max(a, b int) int {
	if a < b {
		a = b
	}
	return a
}

// @lc code=end

