/*
 * @lc app=leetcode id=968 lang=golang
 *
 * [968] Binary Tree Cameras
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
func minCameraCover(root *TreeNode) int {
	res := 0
	var minCamera func(node *TreeNode) int
	minCamera = func(node *TreeNode) int {
		if node == nil {
			return 2
		}
		left, right := minCamera(node.Left), minCamera(node.Right)
		if left == 2 && right == 2 {
			return 0
		}

		if left == 0 || right == 0 {
			res++
			return 1
		}

		if left == 1 || right == 1 {
			return 2
		}
		return -1
	}
	if minCamera(root) == 0 {
		res++
	}
	return res
}

// @lc code=end

