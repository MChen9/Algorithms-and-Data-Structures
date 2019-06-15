class Solution {
    /**
     * [Reference](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48827/Solution-in-C%2B%2B-well-explained)
     * Similar to 153. Find Minimum in Rotated Sorted Array
     */
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int mid;
        while (lo < hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else if (nums[mid] < nums[hi])
                hi = mid;
            else
                hi--;
        }
        return nums[lo];
    }
}
