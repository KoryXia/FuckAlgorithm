/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int cookie_index = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {
            if (cookie_index >= 0 && s[cookie_index] >= g[i]) {
                cookie_index--;
                res++;
            }
        }

        return res;
    }
}
// @lc code=end

