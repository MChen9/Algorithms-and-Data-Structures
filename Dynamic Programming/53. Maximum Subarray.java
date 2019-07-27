class Solution {
    /**
     * Key Points:
     *   If sum is negative, then restart, use a variable to record the max value,
     *   add value from the second to the end, inplace
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
