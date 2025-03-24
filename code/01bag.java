class Solution {
    public int bag(int[] values, int[] weights, int n, int bagWeight) {
        int[][] dp = new int[n][bagWeight + 1];
        // Init the dp array with only put the first object.
        for (int j = weights[0]; j <= bagWeight; j++) {
            dp[0][j] = values[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weights[i]) {
                    // if current weight can't tale i object, value is same as dp[i - 1][j].
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // put: dp[i - 1][j - weights[i]] + values[i]
                    // not put: dp[i - 1][j];
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                }
            }
        }
        return dp[n - 1][bagWeight];
    }
}
// @lc code=end
