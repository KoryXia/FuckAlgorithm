/*
 * @lc app=leetcode id=98 lang=golang
 *
 * [98] Validate Binary Search Tree
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
func check(root *TreeNode, max *int) bool {
	if root == nil {
		return true
	}

	left := check(root.Left, max)
	if !left {
		return false
	}

	if *max >= root.Val {
		return false
	}
	*max = root.Val

	right := check(root.Right, max)
	return right
}

func isValidBST(root *TreeNode) bool {
	prev := math.MinInt64
	return check(root, &prev)
}

// @lc code=end

