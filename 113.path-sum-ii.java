/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        taverse(root, targetSum);
        return res;
    }

    public void taverse(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        path.add(node.val);

        if (node.left == null && node.right == null && target == node.val) {
            res.add(new ArrayList<>(path));    
        }
        
        taverse(node.left, target - node.val);
        taverse(node.right, target - node.val);

        path.removeLast();
    }  
}
// @lc code=end

