package com.trees.BST;

import com.trees.TreeNode;
import com.util.Util;

public class DeleteRangeElements {

	public static void main(String[] args) {
		TreeNode root = Util.getSampleBSTree();
		Util.printInOrder(root);
		root = new DeleteRangeElements().deleteOutOfRange(root, 21, 28);
		Util.printInOrder(root);
	}

	TreeNode deleteOutOfRange(TreeNode root, int A, int B) {

		if (root == null)
			return null;

		if (root.val > B) {
			return deleteOutOfRange(root.left, A, B);
		} else if (root.val < A) {
			return deleteOutOfRange(root.right, A, B);
		} else {
			root.left = deleteOutOfRange(root.left, A, B);
			root.right = deleteOutOfRange(root.right, A, B);
			return root;
		}
	}
}
