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
     * [Reference](https://leetcode.com/problems/find-bottom-left-tree-value/discuss/98786/Verbose-Java-Solution-Binary-tree-level-order-traversal)
     * Key Points:
     *   Use level-order traversal and record the first value in every level
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) val = temp.val; // record the first value in every level
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return val;
    }
}
