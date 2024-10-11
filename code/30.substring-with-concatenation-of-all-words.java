/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - substringLength; i++) {
            Map<String, Integer> visited = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String substring = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (!map.containsKey(substring)) {
                    break;
                }
                visited.put(substring, visited.getOrDefault(substring, 0) + 1);

                if (visited.get(substring) > map.get(substring)) {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

