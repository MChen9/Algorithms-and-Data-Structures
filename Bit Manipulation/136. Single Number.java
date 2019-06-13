class Solution {
    /**
     * [Reference](https://leetcode.com/articles/single-number/)
     * Key points:
     *   To make sure O(1) space, we should use bit manipulation
     *      a XOR 0 = a
     *      a XOR a = 0
     *      a XOR a XOR b = b
     *
     * Time Complexity: O(n). One pass
     * Space Complexity: O(1).
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num: nums) {
            ans ^= num;
        }
        return ans;
    }
}
