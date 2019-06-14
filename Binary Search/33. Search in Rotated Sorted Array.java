class Solution {
    /**
     * [Reference](https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution)
     * Key points:
     *   1. Find the smallest number, which is the pivot of rotation
     *      1.1. Compare mid with hi, if hi is larger, which means 
     *           smallest element cannot in the right part, must be
     *           mid or before
     *      1.2. If number at mid is larger than that at hi, which means
     *           the least number must within [mid + 1, hi]
     *      1.3. When lo == hi or lo > hi, loop terminate since we have
     *           found the least one
     *   2. Find the target number by knowing where is it rotated
     *      2.1. rotMid means the real mid of unrotated array
     *      2.2. If nums[rotMid] > target, which means we should push
     *           idx to the right, so we have hi = mid - 1, so that
     *           rotMid can go back
     *      2.3. Same as ordinary binary search, if rotMid is target,
     *           then return
     *          
     * Time Complexity: O(log N). Twice binary search is also O(log N)
     * Space Complexity: O(1).
     */
    public int search(int[] nums, int target) {
        int lo, hi, mid, rot, rotMid;
        int n = nums.length;
        lo = 0;
        hi = n - 1;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        
        rot = lo;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            rotMid = (rot + mid) % n;
            if (nums[rotMid] == target)
                return rotMid;
            if (nums[rotMid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}
