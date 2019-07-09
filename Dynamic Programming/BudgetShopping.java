import java.util.*;

class BudgetShopping {
	/**
	 * Helen has n = 50 dollars to buy notebooks from m = 2 stores described by
	 * bundleQuantities = [20, 19], bundleCosts = [24, 20], she can buy 40 books at most.
	 *
	 * Key Points:
	 *   1. It differs from 0-1Knapsack, since we can choose same kind item more than once,
	 *      e.g. we can buy 2 bundles of $20, then we pay 48 to have 40 books
	 *   2. We can have following transfer function
	 *      For another example, bundleQuantities = [3, 4, 5], bundleCosts = [2, 3, 4]
	 *        dp[0] = 0, dp[1] = 0, dp[2] = 3, dp[3] = 4, dp[4] = 6
	 *        dp[5] = max{5 + dp[1], 4 + dp[2], 3 + dp[3]}  <-- choose items from bags
	 *        dp[6] = max{5 + dp[2], 4 + dp[3], 3 + dp[4]}
	 *        ...
	 *        dp[i] = max{item_j + dp[i - weight of item_j]}
	 *
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 */
	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts, int m) {
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int maxQ = 0;
			for (int j = 0; j < bundleCosts.length; j++) {
				if (i >= bundleCosts[j])
					maxQ = Math.max(maxQ, bundleQuantities[j] + dp[i - bundleCosts[j]]);
			}
			dp[i] = maxQ;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// int n = 50, m = 2;
		// int[] bundleQuantities = {20, 19}, bundleCosts = {24, 20};
		int n = 4, m = 1;
		int[] bundleQuantities = {10}, bundleCosts = {2};
		System.out.println(budgetShopping(n, bundleQuantities, bundleCosts, m));
	}
}
