/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(traverse(node.left), 0);
        int right = Math.max(traverse(node.right), 0);
        res = Math.max(res, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
// @lc code=end

