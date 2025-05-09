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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        traversal(root, "", res);
        return res;
    }

    public void traversal(TreeNode node, String path, List<String> res) {
        if (node == null) {
            return;
        }

        path += node.val;
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        traversal(node.left, path + "->", res);
        traversal(node.right, path + "->", res);
    }
}
// @lc code=end

