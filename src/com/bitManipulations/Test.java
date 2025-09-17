package com.bitManipulations;

import com.trees.TreeNode;

public class Test {

	class TreeNode {
		public TreeNode right;
		public TreeNode left;
		public Integer val;

		public TreeNode(Integer val) {
			this.val = val;
		}

	}

	TreeNode insert(TreeNode root, int val) {

		if (root == null)
			return new TreeNode(val);

		if (root.val < val)
			root.left = insert(root.left, val);

		if (root.val >= val)
			root.right = insert(root.right, val);

		return root;
	}

	TreeNode delete(int val, TreeNode root) {

		if (val < root.val)
			root.left = delete(val, root.left);
		else if (val > root.val)
			root.right = delete(val, root.right);

		else if (root.left == null && root.right == null)
			return null;

		else if (root.left == null)
			return root.left;

		else if (root.right == null)
			return root.right;

		else {
			int max = getMax(root.left);

			root.val = max;

			root.left = delete(max, root.left);
		}
		return root;
	}

	int getMax(TreeNode root) {

		if (root.right == null)
			return root.val;

		return getMax(root.right);
	}

	public static void main(String[] args) {
		int k = 2;
		char c = (char)k + 48;
		System.out.println(c);
	}

}
