package com.dp;

public class Sirisha {
	
	public static void main(String[] args) {
		int longestLine = new Sirisha().longestLine(new int[][] {
			{0,0,1,1},
			{0,0,0,1},
			{0,0,1,0},
			{0,0,1,1},
			{1,0,1,0}
		});
		
		System.out.println(longestLine);
	}
	
	public int longestLine(int[][] M) {
		int res = 0;
		if (M == null || M.length == 0 || M[0].length == 0) {
			return 0;
		}
		int m = M.length, n = M[0].length;
		int[][][] dp = new int[m][n][4];
		dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = dp[0][0][3] = M[0][0];
		res = Math.max(res, M[0][0]);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (M[i][j] == 1) {
					dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
					if (j > 0) {
						dp[i][j][0] = dp[i][j - 1][0] + 1;
					}
					if (i > 0) {
						dp[i][j][1] = dp[i - 1][j][1] + 1;
					}
					if (i > 0 && j > 0) {
						dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
					}
					if (j + 1 < n && i > 0) {
						dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
					}
					res = Math.max(res, dp[i][j][0]);
					res = Math.max(res, dp[i][j][1]);
					res = Math.max(res, dp[i][j][2]);
					res = Math.max(res, dp[i][j][3]);
				}
			}
		}
		return res;
	}
}