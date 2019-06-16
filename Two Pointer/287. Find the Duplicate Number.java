class Solution {
    /**
     * Same as 142. Linked List Cycle II
     * Key points:
     *   1. Find the location that two pointer meet;
     *   2. Then find the entrance of cycle, which is the same
     *      number at.
     *      
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findDuplicate(int[] nums) {
        int p1 = 0, p2 = 0;
        do {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        } while (p1 != p2);
        
        p1 = 0;
        while (nums[p1] != nums[p2]) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return nums[p1];
    }
}
