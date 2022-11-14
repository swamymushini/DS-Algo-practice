package com.trees.BST;

import com.trees.TreeNode;

public class DistanceBtwNodes {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(
				new Integer[][] { { 6 }, { 2, 15 }, { 1, 4, 10, 18 }, { null, null, null, null, 9, 12, 17, 19 } });
		System.out.println(new DistanceBtwNodes().findLCA(root, 4, 15));
		
//		System.out.println(new DistanceBtwNodes().height(root, 2, 19));
	}

	int findLCA(TreeNode A, int B, int C) {

		if (A == null)
			return 0;

		int val = A.val;

		if (val == B)
			return height(A, C);

		if (val == C)
			return height(A, B);

		if (B < val && val < C) {
			return height(A, B) + height(A, C);
		}

		if (val < B)
			return findLCA(A.right, B, C);
		else
			return findLCA(A.left, B, C);
	}

	int height(TreeNode root, int val) {

		if (root == null)
			return -1;

		if (root.val < val)
			return height(root.right, val) + 1;
		else if (root.val > val)
			return height(root.left, val) + 1;

		return 0;
	}

}
