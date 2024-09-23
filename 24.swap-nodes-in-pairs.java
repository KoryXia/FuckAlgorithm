/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode next = cur.next.next.next;
            cur.next = cur.next.next; // Step 1
            cur.next.next = temp; // Step 2
            cur.next.next.next = next; // Step 3
            cur = cur.next.next; // move cur pointer
        }
        return dummy.next;
    }
}
// @lc code=end

