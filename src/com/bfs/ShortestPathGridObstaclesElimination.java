package com.bfs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class ShortestPathGridObstaclesElimination {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
		System.out.println(new ShortestPathGridObstaclesElimination().shortestPath(grid, 1));
	}

	static class Position {
		int i;
		int j;
		int k;
		int steps;

		Position(int i, int j, int k, int steps) {
			this.i = i;
			this.j = j;
			this.k = k;
			this.steps = steps;
		}

	}

	public int shortestPath(int[][] grid, int k) {

		Queue<Position> qu = new LinkedList<>();

		qu.add(new Position(0, 0, k, 0));

		Set<String> visited = new HashSet<>();

		while (!qu.isEmpty()) {

			Position poll = qu.poll();

			if (visited.contains(poll.i + "-" + poll.j))
				continue;

			if (poll.i == grid.length-1 && poll.j == grid[0].length-1)
				return poll.steps;

			visited.add(poll.i + "-" + poll.j);

			add(grid, qu, visited, poll);

		}

		return -1;
	}

	void add(int[][] grid, Queue<Position> qu, Set<String> visited, Position poll) {

		int i = poll.i;
		int j = poll.j;
		int steps = poll.steps;

		int o = i - 1;
		int p = j;
		int k = poll.k;

		if (isValid(o, p, grid) && (grid[o][p] == 0 || k-- > 0)) {
			qu.add(new Position(o, p, k, steps + 1));
		}

		o = i;
		p = j - 1;
		k = poll.k;

		if (isValid(o, p, grid) && (grid[o][p] == 0 || k-- > 0)) {
			qu.add(new Position(o, p, k, steps + 1));
		}

		o = i + 1;
		p = j;
		k = poll.k;

		if (isValid(o, p, grid) && (grid[o][p] == 0 || k-- > 0)) {
			qu.add(new Position(o, p, k, steps + 1));
		}

		o = i;
		p = j + 1;
		k = poll.k;

		if (isValid(o, p, grid) && (grid[o][p] == 0 || k-- > 0)) {
			qu.add(new Position(o, p, k, steps + 1));
		}

	}

	boolean isValid(int i, int j, int[][] grid) {

		return !(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length);
	}
}