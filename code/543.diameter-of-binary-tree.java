/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root);
        return res - 1;
    }

    public int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traversal(node.left);
        int right = traversal(node.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

