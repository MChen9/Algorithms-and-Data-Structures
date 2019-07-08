import java.util.*;

class KnapSack {
	/**
	 * Key Points:
	 *   1. i means from 0 to i items, the maximun value bag can have
	 *   2. If w = 0 or i = 0
	 *      2.1. If w = 0, then val must be zero
	 *      2.2. If i = 0 and w > wt[i], then it will have value
	 *   3. Other 
	 *      3.1. If wt[i] <= w, then we need to put wi into bag, then 
	 *           add the remainder dp
	 *      3.2. If wt[i] > w, then it has no difference to dp[i-1][w],
	 *           which means it is the same without add new item
	 */
	public static int knapSack(int W, int[] wt, int[] val, int n) {
		int[][] dp = new int[n][W + 1];

		for (int i = 0; i < n; i++) {
			for (int w = 0; w <= W; w++) {
				// fill the first column and the first row
				if (i == 0 || w == 0) {
					if (w == 0)
						dp[i][w] = 0;
					else
						dp[i][w] = (w < wt[i]) ? 0: val[i];
				} else {
					
					if (wt[i] <= w) {
						dp[i][w] = Math.max(dp[i - 1][w], 
							val[i] + dp[i - 1][w - wt[i]]);
					} else {
						dp[i][w] = dp[i - 1][w];
					}
				}
				
			}
		}
		System.out.println(toString(dp));
		return dp[n - 1][W];
	}

	public static void main(String[] args) {
		int[] wt = {10, 20, 30}, val = {60, 100, 120};
		int W = 50, n = 3;
		System.out.println(knapSack(W, wt, val, n));
	}
}
