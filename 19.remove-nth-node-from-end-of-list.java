/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start

import java.util.List;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;

        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        int pos = length - n;
        curr = dummy;

        while (pos > 0) {
            curr = curr.next;
            pos--;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }
}
// @lc code=end

