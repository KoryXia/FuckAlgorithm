/*
 * @lc app=leetcode id=337 lang=golang
 *
 * [337] House Robber III
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
func rob(root *TreeNode) int {
	res := robTree(root)
	return slices.Max(res)
}

func robTree(node *TreeNode) []int {
	if node == nil {
		return []int{0, 0}
	}
	left := robTree(node.Left)
	right := robTree(node.Right)

	unRobNode := slices.Max(left) + slices.Max(right)
	robNode := node.Val + left[0] + right[0]

	return []int{unRobNode, robNode}
}

// @lc code=end

