/*
 * @lc app=leetcode id=257 lang=golang
 *
 * [257] Binary Tree Paths
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
func binaryTreePaths(root *TreeNode) []string {
	res := make([]string, 0)
	var traverse func(node *TreeNode, path string)
	traverse = func(node *TreeNode, path string) {
		if node == nil {
			return
		}

		path += strconv.Itoa(node.Val)
		if node.Left == nil && node.Right == nil {
			res = append(res, path)
			return
		}
		traverse(node.Left, path+"->")
		traverse(node.Right, path+"->")
	}
	traverse(root, "")
	return res
}

// @lc code=end

