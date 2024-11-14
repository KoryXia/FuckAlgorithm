/*
 * @lc app=leetcode id=106 lang=golang
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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

var hashmap map[int]int

func buildTree(inorder []int, postorder []int) *TreeNode {
	hashmap = make(map[int]int)
	for i, v := range inorder {
		hashmap[v] = i
	}

	root := findNode(inorder, postorder, len(postorder)-1, 0, len(inorder)-1)
	return root
}

func findNode(inorder []int, postorder []int, rootIdx int, l, r int) *TreeNode {
	if l > r {
		return nil
	}
	if l == r {
		return &TreeNode{Val: inorder[l]}
	}

	rootV := postorder[rootIdx]
	rootIn := hashmap[rootV]
	root := &TreeNode{Val: rootV}
	root.Left = findNode(inorder, postorder, rootIdx-(r-rootIn)-1, l, rootIn-1)
	root.Right = findNode(inorder, postorder, rootIdx-1, rootIn+1, r)
	return root
}

// @lc code=end

