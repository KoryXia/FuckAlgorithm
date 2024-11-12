/*
 * @lc app=leetcode id=101 lang=golang
 *
 * [101] Symmetric Tree
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
func isSymmetric(root *TreeNode) bool {
	var compare func(left, right *TreeNode) bool
	compare = func(left, right *TreeNode) bool {
		if left == nil && right == nil {
			return true
		}

		if left != nil && right == nil {
			return false
		}

		if left == nil && right != nil {
			return false
		}

		if left.Val != right.Val {
			return false
		}

		outside := compare(left.Left, right.Right)
		inside := compare(left.Right, right.Left)
		return outside && inside
	}

	return compare(root.Left, root.Right)
}

// @lc code=end

