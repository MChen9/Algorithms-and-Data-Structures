class Solution {
    /**
     * [Reference](https://leetcode.com/problems/climbing-stairs/solution/)
     * Key Points:
     *   The total number of rearching n step is the sum of #rearch (n-1)
     *   and #rearch (n-2), since we can only take one or two steps
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
