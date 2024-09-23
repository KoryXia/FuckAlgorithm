/*
 * @lc app=leetcode id=24 lang=golang
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	dummy := &ListNode{
		Next: head,
	}
	cur := dummy

	for cur.Next != nil && cur.Next.Next != nil {
		temp := cur.Next
		next := cur.Next.Next.Next
		cur.Next = cur.Next.Next
		cur.Next.Next = temp
		cur.Next.Next.Next = next
		cur = cur.Next.Next
	}
	return dummy.Next
}

// @lc code=end

