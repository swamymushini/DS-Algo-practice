package com.trees;

public class SymmetricBinaryTree {

	public boolean isSymmetric(TreeNode A) {

		if (A == null)
			return true;

		boolean left = isSymmetric(A.left);

		boolean right = isSymmetric(A.right);

		if (!left || !right)
			return false;

		if (A.left == null && A.right == null)
			return true;

		if (A.left == null || A.right == null)
			return false;

		return A.left.val == A.right.val;
	}

}