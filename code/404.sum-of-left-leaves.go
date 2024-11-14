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
	var countLeftLeavesSum func(node *TreeNode, isLeft bool) int
	countLeftLeavesSum = func(node *TreeNode, isLeft bool) int {
		if node == nil {
			return 0
		}

		if node.Left == nil && node.Right == nil && isLeft {
			return node.Val
		}

		sum := 0
		sum += countLeftLeavesSum(node.Left, true)
		sum += countLeftLeavesSum(node.Right, false)
		return sum
	}

	return countLeftLeavesSum(root, false)
}

// @lc code=end

