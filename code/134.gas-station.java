/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currSum += gas[i] - cost[i];
            totalSum +=  gas[i] - cost[i];
            if (currSum < 0) {
                start = i + 1;
                currSum = 0;
            }
        }

        if (totalSum < 0) {
            return -1;
        }

        return start;
    }
}
// @lc code=end

