class Solution {
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
