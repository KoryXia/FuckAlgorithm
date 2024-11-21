/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    int maxCount = 0;
    int count;
    TreeNode prev;
    public int[] findMode(TreeNode root) {
        find(root);
        int[] modes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            modes[i] = res.get(i);
        }
        return modes;
    }

    public void find(TreeNode node) {
        if (node == null) {
            return;
        }
        find(node.left);
        if (prev == null || node.val != prev.val) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            res.clear();
            res.add(node.val);
            maxCount = count;
        } else if (count == maxCount) {
            res.add(node.val);
        }

        prev = node;
        find(node.right);
    }
}
// @lc code=end

