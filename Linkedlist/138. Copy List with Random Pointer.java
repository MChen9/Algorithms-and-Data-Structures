/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    /**
     * [Reference](https://leetcode.com/articles/copy-list-with-random-pointer/)
     * Key points:
     *   1. Create new next nodes with null random pointer
     *      1 -> 1' -> 2 -> 2'
     *   2. Link random pointers to corresponding nodes
     *   3. Unlink old and new nodes
     *      1 -> 2    1' -> 2'
     *
     * Time Complexity: O(N). Up to 3 pass of the nodes
     * Space Complexity: O(1). Constant extra space for pointers
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node oldHead;
        // new next nodes
        oldHead = head;
        while (oldHead != null) {
            oldHead.next = new Node(oldHead.val, oldHead.next);
            oldHead = oldHead.next.next;
        }
        
        // new random nodes
        oldHead = head;
        while (oldHead != null) {
            if (oldHead.random != null)
                oldHead.next.random = oldHead.random.next;
            oldHead = oldHead.next.next;
        }
        
        // unlink new and old nodes
        oldHead = head;
        Node newHead = oldHead.next;
        Node temp = newHead;
        while (oldHead != null) {
            oldHead.next = temp.next;
            if (oldHead.next != null)
                temp.next = oldHead.next.next;
            oldHead = oldHead.next;
            temp = temp.next;
        }
        return newHead;
    }
}
