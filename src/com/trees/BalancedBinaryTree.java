package com.trees;

public class BalancedBinaryTree {

	public int isBalanced(TreeNode A) {

		if (A == null) {
			return 0;
		}

		int lh = 1 + isBalanced(A.left);
		int rh = 1 + isBalanced(A.right);

		if (Math.abs(lh - rh) > 1) {
			return 0;
		}

		return Math.max(lh, rh);
	}
}
