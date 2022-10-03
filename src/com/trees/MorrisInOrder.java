package com.trees;

import com.util.Util;

public class MorrisInOrder {
	// SC(1)
	public static void main(String[] args) {
		new MorrisInOrder().inOrder(Util.getSampleBSTree());
	}

	void inOrder(TreeNode root) {
		TreeNode curr = root;

		while (curr != null) {

			if (curr.left != null) {

				TreeNode temp = curr.left;

				while (temp.right != null && temp.right != curr) {
					temp = temp.right;
				}

				if (temp.right == null) {
					temp.right = curr;
				} else {
					System.out.print(curr.val + " ");
					curr = curr.right;
					temp.right = null;
				}

				curr = curr.left;
			} else {
				System.out.print(curr.val + " ");
				curr = curr.right;
			}
		}

	}

	TreeNode getLastNodeInorder(TreeNode root) {

		TreeNode temp = root;

		while (temp.right != null) {
			temp = temp.right;
		}

		return temp;
	}

}
