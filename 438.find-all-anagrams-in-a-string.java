/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] charP = p.toCharArray();
        Arrays.sort(charP);

        int left = 0, right = p.length();
        List<Integer> res = new ArrayList<>();
        while (right <= s.length()) {
            char[] charS = s.substring(left, right).toCharArray();
            Arrays.sort(charS);

            if (Arrays.equals(charP, charS)) {
                res.add(left);
            }

            left++;
            right++;
        }

        return res;
    }
}
// @lc code=end

