/*
 * @lc app=leetcode id=108 lang=golang
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
func sortedArrayToBST(nums []int) *TreeNode {
	var build func(nums []int, left, right int) *TreeNode

	build = func(nums []int, left, right int) *TreeNode {
		if left >= right {
			return nil
		}

		if right-left == 1 {
			return &TreeNode{Val: nums[left]}
		}

		mid := left + (right-left)/2
		node := &TreeNode{Val: nums[mid]}
		node.Left = build(nums, left, mid)
		node.Right = build(nums, mid+1, right)
		return node
	}
	return build(nums, 0, len(nums))
}

// @lc code=end

