/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * [Reference I](https://www.youtube.com/watch?v=wGXB9OWhPTg)
     * [Reference II](https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer)
     * Key points:
     *   1. Morris in-order traversal + swap incorrect nodes' values
     *   2. Morris in-order traversal
     *      2.1. In-order traversal of BST will have ascending numbers, if 
     *           there are wrong positions of nodes, then we can find them
     *           by in-order traversal
     *      2.2. To have O(1) space, we cannot use recursion or array for
     *           the algorithm
     *      2.3. To mimic the stack frames push and pop, we need to record
     *           root nodes, since after printing rightmost node, it will
     *           print root node following the in-order traversal
     *      2.4. It is like linkedlist, we will have a pointer(thread) refer
     *           from rightmost node to the root node
     *      2.5. Follow the in-order traversal
     *           2.5.1. If node has no left subtree, then we can just keep going
     *                 to the right tree
     *           2.5.2. If node has left subtree, we find a rightmost node of 
     *                 the left subtree
     *           2.5.3. If there is no thread between rightmost node and the root 
     *                  node, we add one, if any, we simply print the rightmost 
     *                  node and go back to the root
     *   3. Swap incorrect nodes' values
     *      3.1. When first encounter a pre.val > cur.val pair, we know pre is the
     *           larger one, which will be swapped later
     *      3.2. When second encounter a pre.val > cur.val pair, we know cur is the
     *           smaller one, which will be swapped later
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1). Morris traversal
     */
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode first = null, second = null, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                //System.out.println(cur.val);
                if (pre != null && pre.val > cur.val) {
                    if (second == null)
                        second = pre;
                    first = cur;
                }  
                pre = cur;
                cur = cur.right;
                
            } else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur; // rightmost, will come back to root
                    cur = cur.left;
                } else {
                    temp.right = null;
                    //System.out.println(cur.val);
                    if (pre != null && pre.val > cur.val) {
                        if (second == null)
                            second = pre;
                        first = cur;
                    } 
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        if (first != null && second != null) {
            int v = first.val;
            first.val = second.val;
            second.val = v;
        }
    }
}
