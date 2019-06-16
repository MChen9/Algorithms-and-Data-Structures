/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * [Reference](https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.)
     * Key points:
     *   1. Find intersection of two pointers, one pointer with x1 speed,
     *      another one with x2 speed;
     *   2. Set one pointer to head, and keep going to find the entrance 
     *      of cycle.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        // find intersection
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                // find cycle entrance
                p1 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }         
        }
        return null;  
    }
}
