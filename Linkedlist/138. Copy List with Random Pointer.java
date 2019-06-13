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
