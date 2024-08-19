/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> prev = dp.get(i - 1);
                row.add(prev.get(j - 1) + prev.get(j));
            }
            if (i != 0) {
                row.add(1);
            }
            dp.add(row);
        }
        return dp;
    }
}
// @lc code=end

