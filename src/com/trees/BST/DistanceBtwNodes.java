package com.trees.BST;

import com.trees.TreeNode;

public class DistanceBtwNodes {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 6 }, { 2, 15 }, { 1, 4, 10, 18 },
				{ null, null, null, null, 9, 12, 17, 19 },
				{ null, null, null, null, null, null, null, null, 8, null, null, null, null, null, null, null } });
		System.out.println(new DistanceBtwNodes().solve(root, 1, 15));
	}

	int findHeight(TreeNode A, int B) {

		if (A == null)
			return -1;

		if (A.val < B)
			return findHeight(A.right, B) + 1;
		else if (A.val > B)
			return findHeight(A.left, B) + 1;
		else
			return 0;
	}

	public int solve(TreeNode A, int B, int C) {
		TreeNode lca = findLCA(A, B, C);

		if (lca.val == B) {
			return findHeight(lca, C);
		} else if (lca.val == C) {
			return findHeight(lca, B);
		}
		return findHeight(lca, C) + findHeight(lca, B);
	}

	TreeNode findLCA(TreeNode A, int B, int C) {

		if (A == null)
			return null;

		if (A.val == B || A.val == C)
			return A;

		TreeNode left = findLCA(A.left, B, C);
		TreeNode right = findLCA(A.right, B, C);

		if (left != null && right != null) {
			return A;
		} else if (left != null)
			return left;
		else
			return right;

	}

}
