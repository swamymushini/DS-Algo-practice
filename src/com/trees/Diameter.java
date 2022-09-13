package com.trees;

public class Diameter {

	public static void main(String[] args) {

		TreeNode root = TreeNode.buildTree(new Integer[][] { { 15 }, { 12, 20 }, { 9, 14, null, null } });

		int solve = new Diameter().solve(root);
		System.out.println(solve);
	}

	public int solve(TreeNode A) {

		if (A == null)
			return 0;

		int lh = height(A.left);
		int rh = height(A.right);

		int ld = solve(A.left);
		int rd = solve(A.right);

		return Math.max(Math.max(ld, rd), lh + rh + 2);
	}

	public int height(TreeNode A) {

		if (A == null)
			return -1;

		return Math.max(height(A.left), height(A.right)) + 1;
	}
}
