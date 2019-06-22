/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
