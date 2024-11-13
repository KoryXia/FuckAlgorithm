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
	var traversal func(node *TreeNode, path string)
	traversal = func(node *TreeNode, path string) {
		if node == nil {
			return
		}
		if node.Left == nil && node.Right == nil {
			res = append(res, path+strconv.Itoa(node.Val))
			return
		}
		path = path + strconv.Itoa(node.Val) + "->"
		traversal(node.Left, path)
		traversal(node.Right, path)
	}
	traversal(root, "")
	return res
}

// @lc code=end

