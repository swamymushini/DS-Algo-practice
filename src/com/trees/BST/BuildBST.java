package com.trees.BST;

import com.trees.TreeNode;
import com.util.Util;

public class BuildBST {

	public static void main(String[] args) {
		TreeNode root = Util.getSampleBSTree();
		Util.printInOrder(root);
		root = new BuildBST().delete(9, root);
		Util.printInOrder(root);
	}

	TreeNode insert(TreeNode root, int val) {

		if (root == null)
			return new TreeNode(val);

		if (root.val < val)
			root.left = insert(root.left, val);

		if (root.val >= val)
			root.right = insert(root.right, val);

		return root;
	}

	TreeNode delete(int val, TreeNode root) {

		if (val < root.val)
			root.left = delete(val, root.left);
		else if (val > root.val)
			root.right = delete(val, root.right);
		
		else if (root.left == null && root.right == null)
			return null;

		else if (root.left == null)
			return root.left;

		else if (root.right == null)
			return root.right;
		
		else {
			int max = getMax(root.left);

			root.val = max;

			root.left = delete(max, root.left);
		}
		return root;
	}

	int getMax(TreeNode root) {

		if (root.right == null)
			return root.val;

		return getMax(root.right);
	}
}
