class Solution {
    /**
     * [Reference](https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation)
     * Key Points:
     *   1. It has the similar method with 70. Climbing Stairs, the minor difference is that
     *      Climbing Stairs has fixed steps, while this problem has flexible steps;
     *   2. Transition function is that dp[target] = dp[target - num] + ... + dp[target -num],
     *      where num is the element of nums;
     *   3. It can be also solved by recursive, similar to Combination Sum.
     * 
     * Time Complexity: O(m*n), m is target, n is the length of nums
     * Space Complexity: O(m)
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            for (int num: nums) {
                if (t - num >= 0)
                    dp[t] += dp[t - num];
            }
        }
        return dp[target];
    }
}
