/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] array = new int[m + n];
        double median;
        for (int i = 0; i < m; i++) {
            array[i] = nums1[i];
        }
        for (int i = m; i < m + n; i++) {
            array[i] = nums2[i - m];
        }
        // ShellSort
        // for (int gap = (m + n) / 2; gap > 0; gap /= 2) {
        //     for (int i = gap; i < m + n; i++) {
        //         int temp = array[i];
        //         int j;
        //         for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
        //             array[j] = array[j - gap];
        //         }
        //         array[j] = temp;
        //     }
        // }
        
        // PopSort
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j < m + n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        if (array.length % 2 == 0) {
            median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2.0;
        } else {
            median = array[(array.length + 1) / 2 - 1];
        }
        return median;
    }
}
// @lc code=end

