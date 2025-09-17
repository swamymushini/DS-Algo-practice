package com.graphs;

import java.util.ArrayList;

public class DFSTraverse {

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

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		dfs(graph, 1, 6, new boolean[u.length], new ArrayList<>(), res);
		System.out.println(res);
	}

	static void dfs(ArrayList<Integer>[] graph, int curr, int des, boolean[] tracker, ArrayList<Integer> subList,
			ArrayList<ArrayList<Integer>> res) {

		if (tracker[curr]) {
			return;
		}

		subList.add(curr);

		if (curr == des) {
			res.add(new ArrayList<>(subList));
			return;
		}

		tracker[curr] = true;

		for (int j = 0; j < graph[curr].size(); j++) {
			int val = graph[curr].get(j);
			dfs(graph, val, des, tracker, subList, res);
		}

		tracker[curr] = false;

		subList.remove(subList.size() - 1);
	}

	static void dfs2(ArrayList<Integer>[] graph, int curr, int des, boolean[] tracker, ArrayList<Integer> subList,
			ArrayList<ArrayList<Integer>> res) {

		if (tracker[curr]) {
			return;
		}

		subList.add(curr);

		if (curr == des) {
			res.add(new ArrayList<>(subList));
		} else {
			tracker[curr] = true;

			for (int j : graph[curr]) {
				dfs(graph, j, des, tracker, subList, res);
			}

			tracker[curr] = false;
		}

		subList.remove(subList.size() - 1);
	}

}
