/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    private boolean res = true;
    private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        valid(root);
        return res;
    }

    public void valid(TreeNode node) {
        if (node == null) {
            return;
        }

        valid(node.left);
        if (node.val <= prev) {
            res = false;
        }
        prev = node.val;
        valid(node.right);
    }
}
// @lc code=end

