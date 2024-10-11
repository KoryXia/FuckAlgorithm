/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int key = prefixSum - k;
            if (map.containsKey(key)) {
                res += map.get(key);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
// @lc code=end

