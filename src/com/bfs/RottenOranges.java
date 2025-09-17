package com.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	
	public static void main(String[] args) {
		int orangesRotting = new RottenOranges().orangesRotting(new int[][] {{1,2}});
		System.out.println(orangesRotting);
	}

	public int orangesRotting(int[][] grid) {
		int res = 0;
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2)
					queue.add(new int[] { i, j });
				else if (grid[i][j] == 1)
					count++;
			}
		}

		if (count == 0) {
			return 0;
		}

		queue.add(null);

		int m = grid.length;
		int n = grid[0].length;

		while (!queue.isEmpty()) {

			int[] poll = queue.poll();

			if (poll == null) {

				if (queue.isEmpty())
					break;
				res++;
				queue.add(null);

				continue;
			}

			int i = poll[0];
			int j = poll[1];

			if (i - 1 > 0 && grid[i - 1][j] == 1) {
				grid[i - 1][j] = 2;
				queue.add(new int[] { i - 1, j });
				count--;
			}

			if (i + 1 < m && grid[i + 1][j] == 1) {
				grid[i + 1][j] = 2;
				queue.add(new int[] { i + 1, j });
				count--;
			}

			if (j - 1 > 0 && grid[i][j - 1] == 1) {
				grid[i][j - 1] = 2;
				queue.add(new int[] { i, j - 1 });
				count--;
			}

			if (j + 1 < n && grid[i][j + 1] == 1) {
				grid[i][j + 1] = 2;
				queue.add(new int[] { i, j + 1 });
				count--;
			}

		}
		if (count > 0)
			return -1;

		return res;
	}

}