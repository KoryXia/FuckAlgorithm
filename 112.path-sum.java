/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        return dfs(root, 0);

    }

    public boolean dfs(TreeNode root, int curr) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (curr + root.val) == this.target;
        }
        curr += root.val;
        boolean left = dfs(root.left, curr);
        boolean right = dfs(root.right, curr);
        return left || right;
    }
}
// @lc code=end

