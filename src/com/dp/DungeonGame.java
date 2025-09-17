package com.dp;

public class DungeonGame {

	public static void main(String[] args) {
		new DungeonGame().calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } });
	}

	Integer[][] dp = null;

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		dp = new Integer[m][n];
		dp[m - 1][n - 1] = dungeon[m - 1][n - 1];
		return calculateMinimumHP(0, 0, dungeon) + 1;
	}

	public int calculateMinimumHP(int m, int n, int[][] dungeon) {

		if (dp[m][n] != null)
			return dp[m][n];

		if (m + 1 >= dungeon.length) {
			dp[m][n] = dungeon[m][n] + calculateMinimumHP(m, n + 1, dungeon);
		} else if (n + 1 >= dungeon[0].length) {
			dp[m][n] = dungeon[m][n] + calculateMinimumHP(m + 1, n, dungeon);
		} else {
			dp[m][n] = dungeon[m][n]
					+ Math.max(calculateMinimumHP(m, n + 1, dungeon), calculateMinimumHP(m + 1, n, dungeon));
		}

		return dp[m][n];
	}
}
