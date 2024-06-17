/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int k = 1;

        while (k <= n * n) {
            for (int i = left; i <= right; i++, k++) {
                res[top][i] = k;
            }
            top++;

            for (int i = top; i <= bottom; i++, k++) {
                res[i][right] = k;
            }
            right--;

            for (int i = right; i >= left; i--, k++) {
                res[bottom][i] = k;
            }
            bottom--;

            for (int i = bottom; i >= top; i--, k++) {
                res[i][left] = k;
            }
            left++;
        }
        return res;
    }
}
// @lc code=end