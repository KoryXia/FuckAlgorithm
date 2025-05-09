/*
 * @lc app=leetcode id=404 lang=golang
 *
 * [404] Sum of Left Leaves
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
func sumOfLeftLeaves(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left, right := sumOfLeftLeaves(root.Left), sumOfLeftLeaves(root.Right)
	var currLeft int
	if root.Left != nil && root.Left.Left == nil && root.Left.Right == nil {
		currLeft = root.Left.Val
	}
	return left + right + currLeft
}

// @lc code=end

