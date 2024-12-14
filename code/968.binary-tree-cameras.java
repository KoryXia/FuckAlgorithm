/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
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
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (minCamra(root) == 0) {
            res++;
        }
        return res;
    }

    public int minCamra(TreeNode node) {
        if (node == null) {
            return 2;
        }

        int left = minCamra(node.left);
        int right = minCamra(node.right);

        if (left == 2 && right == 2) {
            return 0;
        } 
        if (left == 0 || right == 0) {
            res++;
            return 1;
        } 
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }
}
// @lc code=end

