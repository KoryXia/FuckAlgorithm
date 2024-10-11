/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int offset = 1;
        int count = 1;
        int i = 0;
        int j = 0;
        int loop = 1;
        int[][] res = new int[n][n];
        while (loop <= n / 2) {
            i = startX;
            j = startY;
            for (j = startY; j < n - offset; j++) {
                res[i][j] = count++;
            }

            for (i = startX; i < n - offset; i++) {
                res[i][j] = count++;
            }

            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }

        if (n % 2 == 1){
            res[n / 2][n / 2] = count;
        }
        return res;
    }
}
// @lc code=end