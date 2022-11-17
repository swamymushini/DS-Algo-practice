package com.trees;

public class SumBinaryTree {

	public Integer isSumTree(TreeNode A) {

		if (A == null)
			return 0;

		if (A.left == null && A.right == null)
			return A.val;

		Integer lh = isSumTree(A.left);
		Integer rh = isSumTree(A.right);

		if (lh == null || rh == null)
			return null;

		if (lh + rh == A.val)
			return 2 * A.val;

		return null;
	}
}