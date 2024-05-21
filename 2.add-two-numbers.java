/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 != null)?l1.val:0;
            int num2 = (l2 != null)?l2.val:0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
// @lc code=end
