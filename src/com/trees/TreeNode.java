package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode().buildTree(new Integer[][] { { 1 }, { 1, 2 }, { 1, 2, null, 4 } });
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

	TreeNode buildTree(Integer[][] arr) {

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

				qu.add(node.left);
				qu.add(node.right);
			}
		}

		return root;
	}

	void printTree(TreeNode root) {

		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(root);
		
		while(qu.isEmpty()) {}

	}
}
