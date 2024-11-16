/*
 * @lc app=leetcode id=654 lang=golang
 *
 * [654] Maximum Binary Tree
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
func constructMaximumBinaryTree(nums []int) *TreeNode {
	var buildTree func(nums []int, leftIndex, rightIndex int) *TreeNode
	buildTree = func(nums []int, leftIndex, rightIndex int) *TreeNode {
		if rightIndex-leftIndex < 1 {
			return nil
		}
		if rightIndex-leftIndex == 1 {
			return &TreeNode{Val: nums[leftIndex]}
		}

		maxIndex := leftIndex
		maxValue := nums[leftIndex]
		for i := leftIndex + 1; i < rightIndex; i++ {
			if nums[i] > maxValue {
				maxValue = nums[i]
				maxIndex = i
			}
		}

		root := &TreeNode{Val: maxValue}
		root.Left = buildTree(nums, leftIndex, maxIndex)
		root.Right = buildTree(nums, maxIndex+1, rightIndex)
		return root
	}
	return buildTree(nums, 0, len(nums))
}

// @lc code=end

