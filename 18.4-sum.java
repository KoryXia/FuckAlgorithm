/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) { 
            long x = nums[a]; 

            if (a > 0 && x == nums[a - 1]) {
                continue; 
            }
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }

            if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
                
            for (int b = a + 1; b < n - 2; b++) {
                long y = nums[b];
                
                if (b > a + 1 && y == nums[b - 1]) {
                    continue;
                }
                if (x + y + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if (x + y + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                int left = b + 1, right = n - 1;

                while (left < right) {
                    long sum = x + y + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        ans.add(List.of((int) x, (int) y, nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
