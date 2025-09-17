package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MazeExit {

	public static void main(String[] args) {

		char[][] maze = { { '+', '+', '.', '+' },
						  { '+', '.', '.', '+' },
						  { '+', '+', '+', '.' } };
		// Define the entrance as an array
		int[] entrance = { 1, 1 };
		int nearestExit = new MazeExit().nearestExit(maze, entrance);
		System.out.println(nearestExit);

	}

	public int nearestExit(char[][] maze, int[] entrance) {

		Map<String, List<String>> map = new HashMap<>();

		int m = maze.length;
		int n = maze[0].length;

		for (int i = 0; i < maze.length; i++) {

			for (int j = 0; j < maze[0].length; j++) {

				if (maze[i][j] == '+')
					continue;

				if (i - 1 >= 0 && maze[i - 1][j] == '.')
					map.computeIfAbsent(i + "-" + j, k -> new ArrayList<>()).add((i - 1) + "-" + j);

				if (i + 1 < m && maze[i + 1][j] == '.')
					map.computeIfAbsent(i + "-" + j, k -> new ArrayList<>()).add((i + 1) + "-" + j);

				if (j - 1 >= 0 && maze[i][j - 1] == '.')
					map.computeIfAbsent(i + "-" + j, k -> new ArrayList<>()).add(i + "-" + (j - 1));

				if (j + 1 < n && maze[i][j + 1] == '.')
					map.computeIfAbsent(i + "-" + j, k -> new ArrayList<>()).add(i + "-" + (j + 1));

			}

		}

		return bfs(map, entrance[0] + "-" + entrance[1], m, n);
	}

	int bfs(Map<String, List<String>> map, String start, int m, int n) {

		Queue<String> qu = new LinkedList<>();
		qu.add(start);
		qu.add(null);

		int count = 1;

		Set<String> tracker = new HashSet<>();

		while (!qu.isEmpty()) {

			String poll = qu.poll();

			if (poll == null) {

				count++;

				if (!qu.isEmpty())
					qu.add(null);
				else
					return -1;

			}

			if (tracker.contains(poll)) {
				continue;
			}

			tracker.add(poll);

			List<String> list = map.get(poll);

			if (list == null)
				continue;

			for (String val : list) {

				if (!val.equals(start) && checkExit(val, m, n))
					return count;

				if (!tracker.contains(val)) {
					qu.add(val);
				}
			}

		}

		return -1;
	}

	boolean checkExit(String val, int m, int n) {

		return val.startsWith("0-") || val.endsWith("-0") || val.startsWith((m - 1) + "-")
				|| val.endsWith("-" + (n - 1));
	}

}
