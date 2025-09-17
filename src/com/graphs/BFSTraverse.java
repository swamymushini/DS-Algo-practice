package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraverse {

	public static void main(String[] args) {

		int[] u = new int[] { 1, 1, 2, 2, 3, 5, 4 };
		int[] v = new int[] { 2, 4, 4, 3, 5, 6, 5 };

		ArrayList<Integer>[] graph = new ArrayList[u.length + 1];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < u.length; i++) {
			int a = u[i];
			int b = v[i];
			graph[a].add(b);
			graph[b].add(a);
		}

		int src = 1;
		int des = 6;

		Queue<Integer> qu = new LinkedList<>();
		qu.add(src);

		boolean[] tracker = new boolean[graph.length];
		int[] parent = new int[graph.length];

		while (!qu.isEmpty()) {

			Integer poll = qu.poll();

			if (poll == des) {
				System.out.println("arrived");
				break;
			}

			tracker[poll] = true;

			for (int j = 0; j < graph[poll].size(); j++) {
				int val = graph[poll].get(j);
				if (!tracker[val]) {
					parent[val] = poll;
					qu.add(val);
				}
			}
		}

		int sub = parent[des];
		System.out.print(des + " -> ");
		while (sub != src) {
			System.out.print(sub + " -> ");
			sub = parent[sub];
		}
		System.out.print(src + " -> ");

	}

}
