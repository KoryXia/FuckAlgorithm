/*
 * @lc app=leetcode id=530 lang=golang
 *
 * [530] Minimum Absolute Difference in BST
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
func getMinimumDifference(root *TreeNode) int {
	var prev *TreeNode
	result := math.MaxInt64
	var traversal func(node *TreeNode)
	traversal = func(node *TreeNode) {
		if node == nil {
			return
		}
		traversal(node.Left)
		if prev != nil && node.Val-prev.Val < result {
			result = node.Val - prev.Val
		}
		prev = node
		traversal(node.Right)
	}
	traversal(root)
	return result
}

// @lc code=end

