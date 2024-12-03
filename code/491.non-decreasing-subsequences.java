/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Non-decreasing Subsequences
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }
    private void backTracking(int[] nums, int startIndex){
        if(path.size() >= 2) {
            result.add(new ArrayList<>(path));            
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = startIndex; i < nums.length; i++){
            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
// @lc code=end
