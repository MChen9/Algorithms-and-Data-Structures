import java.util.*;

class Solution {
    /**
     * [Reference](https://leetcode.com/articles/permutations/)
     * Key points:
     *   1. Use first as a pointer for swapping idx
     *      1.1. first from 0 to n, then swap first with idx from itself to n
     *      1.2. when fix first, then do DFS respectively.
     *
     * Time Complexity: factorial
     * Space Complexity: O(N!) 
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        for (int num: nums) {
            n.add(num);
        }
        backtracking(n, 0, res);
        return res;
    }
    
    private void backtracking(List<Integer> nums, int first, List<List<Integer>> res) {
        
        if (first == nums.size()) {
            res.add(new ArrayList<Integer>(nums)); // construct new object, or will point to same object all the time
        } else {
            for (int i = first; i < nums.size(); i++) {
                Collections.swap(nums, first, i);
                backtracking(nums, first + 1, res);
                Collections.swap(nums, first, i);
            }
        }       
    }
    
}
