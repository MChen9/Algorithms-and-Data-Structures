class Solution {
    /**
     * Key Points:
     *   1. Special handling for -1, initialize dp with max value;
     *   2. When amount is i, we select one coin from coins, then 
     *      the result add 1 to dp[i - coin].
     *
     * Time Complexity: O(amount*#coins)
     * Space Complexity: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); 
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
            
        }
        return dp[amount] > amount? -1:dp[amount];
    }
}
