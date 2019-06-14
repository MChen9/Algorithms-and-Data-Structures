class Solution {
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
