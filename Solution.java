/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> map = new HashSet<>();
        while(headA != null) {
            map.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if (map.contains(headB)) {
                return headB;
            }
            map.add(headB);
            headB = headB.next;
        }
        return null;

        // ListNode currA = headA;
        // ListNode currB = headB;

        // if (currA == null || currB == null) {
        //   return null;
        // }
        // while (currA != currB) {
        //     currA = currA == null ? headB : currA.next;
        //     currB = currB == null ? headA : currB.next;
        // }
        // return currA;
    }
}
// @lc code=end

