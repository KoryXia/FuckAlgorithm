/*
 * @lc app=leetcode id=110 lang=golang
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
	var getHeight func(node *TreeNode) int
	getHeight = func(node *TreeNode) int {
		if node == nil {
			return 0
		}

		left := getHeight(node.Left)
		if left == -1 {
			return -1
		}

		right := getHeight(node.Right)
		if right == -1 {
			return -1
		}

		if left-right > 1 || right-left > 1 {
			return -1
		} else {
			return max(left, right) + 1
		}
	}
	return getHeight(root) != -1
}

// @lc code=end

