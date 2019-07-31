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
