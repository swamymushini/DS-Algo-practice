package com.trees;

public class InOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 11 }, { 6, 15 }, { 2, 9, 7, null },
				{ null, null, 13, null, null, null, null, null } });

		new InOrderTraversal().inOrder(root);
	}

	void inOrder(TreeNode root) {

		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

}
