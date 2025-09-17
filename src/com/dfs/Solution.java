package com.dfs;

import java.util.Iterator;

class NumIslands {

	public int numIslands(char[][] grid) {
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (grid[i][j] == '1') {
					res++;
					visitIsland(grid, i, j);
				}
			}
		}

		return res;
	}

	void visitIsland(char[][] grid, int i, int j) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length) {
			return;
		}

		if (grid[i][j] == '1') {
			grid[i][j] = '2';
			visitIsland(grid, i, j + 1);
			visitIsland(grid, i, j - 1);
			visitIsland(grid, i + 1, j);
			visitIsland(grid, i - 1, j);
		}

	}

}