package com.dp;

public class PaintHouse {

	public static void main(String[] args) {
		System.out.println(new PaintHouse().solve(new int[][] { { 1, 2, 3 }, { 10, 11, 12 } }));
	}

	public int solve(int[][] A) {
		int n = A.length;

		int[][] dp = new int[3][A.length + 1];

		for (int i = 1; i <= A.length; i++) {

			dp[0][i] = A[i-1][0] + Math.min(dp[1][i - 1], dp[2][i - 1]);
			dp[1][i] = A[i-1][1] + Math.min(dp[0][i - 1], dp[2][i - 1]);
			dp[2][i] = A[i-1][2] + Math.min(dp[0][i - 1], dp[1][i - 1]);

		}

		return Math.min(Math.min(dp[0][n], dp[1][n]), dp[2][n]);

	}
}
