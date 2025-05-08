/*
 * @lc app=leetcode id=222 lang=golang
 *
 * [222] Count Complete Tree Nodes
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
func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left, right := root.Left, root.Right
	leftDeepth, rightDeepth := 0, 0
	for left != nil {
		left = left.Left
		leftDeepth++
	}
	for right != nil {
		right = right.Right
		rightDeepth++
	}
	if leftDeepth == rightDeepth {
		return (2 << leftDeepth) - 1
	}
	return countNodes(root.Left) + countNodes(root.Right) + 1
}

// @lc code=end

