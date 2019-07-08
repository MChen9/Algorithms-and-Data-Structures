import java.util.*;

class KnapSack {
	public static int knapSack(int W, int[] wt, int[] val, int n) {
		int[][] dp = new int[n][W + 1];

		for (int i = 0; i < n; i++) {
			for (int w = 0; w <= W; w++) {
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

	public static String toString(int[][] m) {
		String s = "[ ";
		for (int i = 0; i < m.length; i++) {
			s += "[";
			for (int j = 0; j < m[0].length; j++) {
				s += m[i][j] + ",";
			}
			s += "]\n";
		}
		s += "]";
		return s;
	}

	public static void main(String[] args) {
		int[] wt = {10, 20, 30}, val = {60, 100, 120};
		int W = 50, n = 3;
		System.out.println(knapSack(W, wt, val, n));
	}
}
