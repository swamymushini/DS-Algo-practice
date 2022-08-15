package com.trees;

public class PreOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 11 }, { 6, 15 }, { 2, 9, 7, null },
				{ null, null, 13, null, null, null, null, null } });

		new PreOrderTraversal().preOrder(root);

	}

	void preOrder(TreeNode root) {

		if (root == null)
			return;

		System.out.print(root.val+" ");

		preOrder(root.left);
		preOrder(root.right);
	}

}
