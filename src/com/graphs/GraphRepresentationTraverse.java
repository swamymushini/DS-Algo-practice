package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphRepresentationTraverse {

	public static void main(String[] args) {

		int[] u = new int[] { 1, 1, 2, 2, 3, 5, 4 };
		int[] v = new int[] { 2, 4, 4, 3, 5, 6, 5 };

		ArrayList<Integer>[] arrayOfLists = new ArrayList[u.length + 1];

		for (int i = 0; i < arrayOfLists.length; i++) {
			arrayOfLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < u.length; i++) {
			int a = u[i];
			int b = v[i];
			arrayOfLists[a].add(b);
			arrayOfLists[b].add(a);
		}

		boolean[] tracker = new boolean[7];

		Queue<Integer> que = new LinkedList<>();
		que.add(1);

		while (!que.isEmpty()) {

			int poll = que.poll();

			for (int i = 0; i < arrayOfLists[poll].size(); i++) {

				int num = arrayOfLists[poll].get(i);

				if (!tracker[num]) {
					tracker[num] = true;
					que.add(num);
				}

			}

			tracker[poll] = true;

		}

		System.out.println(tracker[6]);

//		pathTracker(arrayOfLists, u.length, 1, 6);
		dfs(arrayOfLists, u.length, 1, 6);

	}

//	bfs
	static void pathTracker(ArrayList<Integer>[] arrayOfLists, int edges, int src, int des) {

		boolean[] tracker = new boolean[7];
		int[] parent = new int[7];

		Queue<Integer> que = new LinkedList<>();
		que.add(src);

		while (!que.isEmpty()) {

			int poll = que.poll();

			for (int i = 0; i < arrayOfLists[poll].size(); i++) {

				int num = arrayOfLists[poll].get(i);

				if (!tracker[num]) {
					parent[num] = poll;
					tracker[num] = true;
					que.add(num);
				}

			}

			tracker[poll] = true;

		}

		int dest = des;

		while (dest != src) {
			System.out.print(dest + " --> ");
			dest = parent[dest];
		}

		System.out.print(src);

	}

	// dfs
	static void dfs(ArrayList<Integer>[] arrayOfLists, int edges, int src, int des) {
		boolean[] tracker = new boolean[7];
		System.out.println(dfs(arrayOfLists, src, tracker, des));
	}

	static boolean dfs(ArrayList<Integer>[] arrayOfLists, int node, boolean[] tracker, int des) {
		tracker[node] = true;
		if (node == des) {
			System.out.println("reached");
			return true;
		}
		boolean check = false;
		for (int i = 0; i < arrayOfLists[node].size(); i++) {

			int num = arrayOfLists[node].get(i);

			if (!tracker[num]) {
//				tracker[num] = true;
				check = check || dfs(arrayOfLists, num, tracker, des);
				if (check)
					System.out.print(num + " --> ");
			}

		}

		return check;
	}

}
