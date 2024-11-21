/*
 * @lc app=leetcode id=501 lang=golang
 *
 * [501] Find Mode in Binary Search Tree
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
func findMode(root *TreeNode) []int {
	res := make([]int, 0)
	count := 1
	maxCount := 1
	var prev *TreeNode
	var traversal func(node *TreeNode)
	traversal = func(node *TreeNode) {
		if node == nil {
			return
		}
		traversal(node.Left)
		if prev == nil || prev.Val != node.Val {
			count = 1
		} else {
			count++
		}

		if count >= maxCount {
			if count != maxCount && len(res) > 0 {
				res = []int{node.Val}
			} else {
				res = append(res, node.Val)
			}
			maxCount = count
		}
		prev = node
		traversal(node.Right)
	}
	traversal(root)
	return res
}

// @lc code=end

