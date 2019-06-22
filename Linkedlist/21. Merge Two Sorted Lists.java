/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * [Reference](https://leetcode.com/articles/merged-two-sorted-lists/)
     * Key points:
     *   1. Some elements in one list may be larger than many elements of another
     *      list, e.g. l1 = [5], l2 = [1,2,4], if use iteration on the same pace
     *      of two lists, then may be wrong result, like [1,5,2,4];
     *   2. We only append new node of smaller one, and finally append the rest 
     *      list.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1), only use pointers
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (l1 == null) ? l2: l1;
        
        return newHead.next;
    }
}
