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
        int lenA = 0, lenB  = 0;
        ListNode dummy;
        dummy = headA;
        while (dummy != null) {
            lenA++;
            dummy = dummy.next;
        }
        
        dummy = headB;
        while (dummy != null) {
            lenB++;
            dummy = dummy.next;
        }
        
        while (lenA != lenB) {
            if (lenA > lenB) {
                headA = headA.next;
                lenA--;
            } else if (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
