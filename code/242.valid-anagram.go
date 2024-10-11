/*
 * @lc app=leetcode id=242 lang=golang
 *
 * [242] Valid Anagram
 */

// @lc code=start
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	byteMap := make(map[byte]int, len(s))

	for i := 0; i < len(s); i++ {
		byteMap[s[i]]++
		byteMap[t[i]]--
	}

	for _, v := range byteMap {
		if v != 0 {
			return false
		}
	}
	return true
}

// @lc code=end

