package com.trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class InfectionTime {

	HashSet<Integer> visited = new HashSet<>();
	HashMap<Integer, TreeNode> parent = new HashMap<>();

	public int amountOfTime(TreeNode root, int start) {

		Queue<TreeNode> qu = new LinkedList<>();
		int count = 0;
		qu.add(root);
		TreeNode infected = null;

		while (!qu.isEmpty()) {

			TreeNode poll = qu.poll();

			if (poll.left != null) {
				qu.add(poll.left);
				parent.put(poll.left.val, poll);
				if (poll.left.val == start) {
					infected = poll.left;
					break;
				}
			}

			if (poll.right != null) {
				qu.add(poll.right);
				parent.put(poll.right.val, poll);
				if (poll.right.val == start) {
					infected = poll.right;
					break;
				}
			}

		}

		qu = new LinkedList<>();
		qu.add(infected);
		qu.add(null);
		visited.add(infected.val);

		while (!qu.isEmpty()) {

			TreeNode poll = qu.poll();

			if (poll == null) {
				count++;
				if (!qu.isEmpty()) {
					qu.add(null);
				}
			}

			if (poll.left != null && !visited.contains(poll.left.val)) {
				visited.add(poll.left.val);
				qu.add(poll.left);
			}

			if (poll.right != null && !visited.contains(poll.right.val)) {
				visited.add(poll.right.val);
				qu.add(poll.right);
			}

			if (parent.get(poll.val) != null && !visited.contains(parent.get(poll.val).val)) {
				visited.add(parent.get(poll.val).val);
				qu.add(parent.get(poll.val));
			}

		}

		return count;
	}

}