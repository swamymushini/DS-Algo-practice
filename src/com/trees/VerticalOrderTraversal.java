package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(
				new Integer[][] { { 1 }, { 1, 2 }, { 1, 2, null, 4 }, { 3, null, 6, 5, null, null, 9, null } });

		System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(root));
		;
	}

	class Pair {

		TreeNode node;
		Integer dist;

		public Pair(TreeNode node, Integer dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

		Pair root = new Pair(A, 0);

		Queue<Pair> qu = new LinkedList<>();

		qu.add(root);
		qu.add(null);

		while (!qu.isEmpty()) {

			Pair poll = qu.poll();

			if (poll == null) {

				if (qu.isEmpty())
					break;

				qu.add(null);
				continue;
			}

			ArrayList<Integer> list = map.getOrDefault(poll.dist, new ArrayList<>());
			int dist = poll.dist;
			list.add(poll.node.val);

			map.put(dist, list);

			if (poll.node.left != null) {
				qu.add(new Pair(poll.node.left, dist - 1));
			}

			if (poll.node.right != null) {
				qu.add(new Pair(poll.node.right, dist + 1));
			}

		}

		return new ArrayList<ArrayList<Integer>>(map.values());
	}

}
