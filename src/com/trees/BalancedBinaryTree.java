package com.trees;

public class BalancedBinaryTree {

	public int isBalanced(TreeNode A) {

		if (A == null) {
			return 1;
		}

		int lh = height(A.left);
		int rh = height(A.right);

		if (!(Math.abs(lh - rh) <= 1)) {
			return 0;
		}

		if (isBalanced(A.left) == 0)
			return 0;

		if (isBalanced(A.right) == 0)
			return 0;

		return 1;
	}

	int height(TreeNode root) {

		if (root == null)
			return -1;

		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
