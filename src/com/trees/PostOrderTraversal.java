package com.trees;

public class PostOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 11 }, { 6, 15 }, { 2, 9, 7, null },
				{ null, null, 13, null, null, null, null, null } });

		new PostOrderTraversal().postOrder(root);

	}

	void postOrder(TreeNode root) {

		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

}
