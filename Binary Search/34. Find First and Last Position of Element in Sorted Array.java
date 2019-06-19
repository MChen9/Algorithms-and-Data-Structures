class Solution {
    /**
     * [Reference](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14734/Easy-java-O(logn)-solution)
     * Key points:
     *   Two binary search for two idices of target, one for left part, one for right part.
     *   
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchFirst(nums, target),
                         searchLast(nums, target)};
    }
    
    private int searchFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int idx = -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) 
                idx = mid;
            if (nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return idx;
    }
    
    private int searchLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int idx = -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) 
                idx = mid;
            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return idx;
    }
}
