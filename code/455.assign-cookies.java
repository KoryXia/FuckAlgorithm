/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIndex = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0 && cookieIndex >= 0; i--) {
            if (g[i] <= s[cookieIndex]) {
                cookieIndex--;
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
