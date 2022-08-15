package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(
				new Integer[][] { { 1 }, { 1, 2 }, { 1, 2, null, 4 }, { 3, null, 6, 5, null, null, 9, null } });
		TreeNode.printTree(root);
		System.out.println(root);
	}

	TreeNode right;
	TreeNode left;
	Integer val;

	public TreeNode(Integer val) {
		this.val = val;
	}

	public TreeNode() {
	}

	public static TreeNode buildTree(Integer[][] arr) {

		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(arr[0][0]);
		qu.add(root);

		for (int i = 1; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j = j + 2) {

				TreeNode node = qu.poll();

				if (arr[i][j] != null)
					node.left = new TreeNode(arr[i][j]);

				if (arr[i][j + 1] != null)
					node.right = new TreeNode(arr[i][j + 1]);

				if (node == null) {
					qu.add(null);
					qu.add(null);
				} else {
					qu.add(node.left);
					qu.add(node.right);
				}
			}
		}

		return root;
	}

	public static void printTree(TreeNode root) {

		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(root);
		qu.add(new TreeNode(null));

		while (!qu.isEmpty()) {

			TreeNode poll = qu.poll();

			if (poll == null) {
				System.out.print("  ");
				continue;
			}

			if (poll.val == null) {
				if (!qu.isEmpty())
					qu.add(new TreeNode(null));
				System.out.println();
			} else {
				System.out.print(poll.val + " ");
				if (poll.left != null || poll.right != null) {
					qu.add(poll.left);
					qu.add(poll.right);
				}
			}
		}

	}
}
