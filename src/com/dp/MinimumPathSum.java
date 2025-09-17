package com.dp;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		System.out.println(new MinimumPathSum().minPathSum(grid));
	}

	public int minPathSum(int[][] grid) {

		Integer[][] dp = new Integer[grid.length + 1][grid[0].length + 1];

		minPathSum(grid, dp, 0, 0);

		return dp[0][0];
	}

	public int minPathSum(int[][] grid, Integer[][] dp, int i, int j) {

		if (i >= grid.length || j >= grid[0].length)
			return 500;

		if (dp[i][j] != null)
			return dp[i][j];

		dp[i][j] = grid[i][j] + Math.min(minPathSum(grid, dp, i + 1, j), minPathSum(grid, dp, i, j + 1));

		return dp[i][j];
	}
}