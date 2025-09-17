package com.trees;

public class FlattenToLinkedList {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 1 }, { 2, 5 }, { 3, 4, null, 6 }, });
		new FlattenToLinkedList().preOrder(root);

	}

	void preOrder(TreeNode root) {

		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;

		preOrder(left);

		if (root.left != null) {
			root.right = left;
			left.right = right;
			root.left = null;
		}

		preOrder(right);

	}
}