/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    /**
     * [Reference](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/discuss/183060/Java-BFS-Iterative-Solution)
     * Key points:
     *   Use queue size to store the loop length, so that it can loop on every level
     *
     * Time Complexity: O(N), #nodes
     * Space Complexity: O(N)
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // size is changing, need a varaible to store it
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                for (Node child:temp.children) {
                    queue.offer(child);
                } 
            }
            depth++;       
        }
        return depth;
    }
}
