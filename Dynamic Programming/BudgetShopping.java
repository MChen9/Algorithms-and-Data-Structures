import java.util.*;

class BudgetShopping {
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
	// static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts, int m) {
	// 	List<Integer> Qt = new ArrayList<>();
	// 	List<Integer> Qc = new ArrayList<>();
	// 	for (int i = 0; i < bundleCosts.length; i++) {
	// 		int cost = n;
	// 		while (cost >= bundleCosts[i]) {
	// 			Qt.add(bundleQuantities[i]);
	// 			Qc.add(bundleCosts[i]);
	// 			cost -= bundleCosts[i];
	// 		}
	// 	}
	// 	System.out.println(Qt.toString());
	// 	int[] wt = new int[Qc.size()];
	// 	int[] val = new int[Qt.size()];
	// 	for (int i = 0; i < Qt.size(); i++) {
	// 		wt[i] = Qc.get(i);
	// 		val[i] = Qt.get(i);
	// 	}

	// 	return knapSack(n, wt, val, Qt.size());

	// }

	// static int knapSack(int W, int[] wt, int[] val, int n) {
	// 	int[][] dp = new int[n][W + 1];

	// 	for (int i = 0; i < n; i++) {
	// 		for (int w = 0; w <= W; w++) {
	// 			if (i == 0 || w == 0) {
	// 				if (w == 0)
	// 					dp[i][w] = 0;
	// 				else
	// 					dp[i][w] = (w < wt[i]) ? 0: val[i];
	// 			} else {
					
	// 				if (wt[i] <= w) {
	// 					dp[i][w] = Math.max(dp[i - 1][w], 
	// 						val[i] + dp[i - 1][w - wt[i]]);
	// 				} else {
	// 					dp[i][w] = dp[i - 1][w];
	// 				}
	// 			}
				
	// 		}
	// 	}
	// 	return dp[n - 1][W];
	// }

	public static void main(String[] args) {
		// int n = 50, m = 2;
		// int[] bundleQuantities = {20, 19}, bundleCosts = {24, 20};
		int n = 4, m = 1;
		int[] bundleQuantities = {10}, bundleCosts = {2};
		System.out.println(budgetShopping(n, bundleQuantities, bundleCosts, m));
	}
}
