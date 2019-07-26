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
     * Key Points:
     *   1. Since head can be the one we need to remove, so adding a dummy node 
     *      point to head;
     *   2. Use p1 to record the position before removed node, and p2 to detect
     *      whether we get end, and distance between p2 and p1 is n;
     *   3. [two pass] one pass for getting length of list, another pass for 
     *      find len - n + 1 node.
     *
     * Time Complexity: O(n), on pass
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = p1;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return dummy.next;
    }
}
