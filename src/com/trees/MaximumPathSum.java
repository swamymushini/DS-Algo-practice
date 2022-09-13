package com.trees;

public class MaximumPathSum {

	public static void main(String[] args) {

		TreeNode root = TreeNode.buildTree(new Integer[][] { { -2 }, { null, -1 } });

		int solve = new MaximumPathSum().maxPathSum(root);
		System.out.println(solve);
	}

	public int maxPathSum(TreeNode root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return root.val;

		int lh = getPathSum(root.left);
		int rh = getPathSum(root.right);

		int ld = maxPathSum(root.left);
		int rd = maxPathSum(root.right);

		return Math.max(Math.max(Math.max(ld, rd), lh + rh + root.val), root.val);
	}

	int getPathSum(TreeNode root) {

		if (root == null)
			return 0;

		return getPathSum(root.left) + getPathSum(root.right) + root.val;
	}

}