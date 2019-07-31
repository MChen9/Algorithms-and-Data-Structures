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
     * Based on [104. Maximum Depth of Binary Tree]
     * Key Points:
     *   If the difference between maxDepth of left and that of right is 
     *   larger than 1, then the field isBalanced is false, althouth it 
     *   will go through all the tree
     *
     * Time Complexity: O(N), N is #nodes
     * Space Complexity: O(N)
     */
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        getMaxHeight(root);
        return isBalanced;
    }
    
    int getMaxHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getMaxHeight(root.left);
        int right = getMaxHeight(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
