/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root, "");
        return res;
    }

    public void traversal(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(new StringBuilder(path).append(node.val).toString());
            return;
        }

        String newPath = new StringBuilder(path).append(node.val).append("->").toString(); 
        traversal(node.left, newPath);
        traversal(node.right, newPath);
    }
}
// @lc code=end

