package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ReorderRoutes {

	public static void main(String[] args) {
		int minReorder = minReorder(6, new int[][] { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } });
		System.out.println(minReorder);
	}

	static class Node {
		int direction;
		int b;

		public Node(int b, int direction) {
			this.direction = direction;
			this.b = b;
		}
	}

	public static int minReorder(int n, int[][] connections) {
		int count = 0;

		Map<Integer, ArrayList<Node>> map = new HashMap<>();

		for (int i = 0; i < connections.length; i++) {
			int[] val = connections[i];
			map.computeIfAbsent(val[0], k -> new ArrayList<>()).add(new Node(val[1], 1));
			map.computeIfAbsent(val[1], k -> new ArrayList<>()).add(new Node(val[0], -1));
		}

		Queue<Node> qu = new LinkedList<>();
		boolean[] tracker = new boolean[n];

		qu.add(new Node(0, -1));

		while (!qu.isEmpty()) {

			Node poll = qu.poll();

			if (tracker[poll.b])
				continue;

			tracker[poll.b] = true;

			ArrayList<Node> arrayList = map.get(poll.b);

			for (Node node : arrayList) {

				if (tracker[node.b])
					continue;

				if (node.direction == 1)
					count++;

				qu.add(node);
			}

		}

		return count;
	}

}
