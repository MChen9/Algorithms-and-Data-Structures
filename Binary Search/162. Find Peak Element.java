class Solution {
    /**
     * [Reference](https://leetcode.com/articles/find-peak-element/)
     * Similar to [852. Peak Index in a Mountain Array]
     *   
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l < r) { //must have two elements
            mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l; // peak must be at the left part
    }
}
