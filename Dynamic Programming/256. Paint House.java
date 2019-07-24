class Solution {
    /**
     * Key Points:
     *   1. dp[i][j] means when ith house paints j color, the min cost of from 0 to ith houses;
     *   2. Initialize dp[0][0], dp[0][1], dp[0][2] means the cost of 0th house paints diff color;
     *   3. dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]) means when ith house paint 
     *      0th color, the min costs of all, so we need to know the min costs of previous houses.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n^2)
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }
        
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
