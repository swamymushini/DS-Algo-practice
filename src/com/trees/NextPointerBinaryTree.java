package com.trees;

public class NextPointerBinaryTree {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(
				new Integer[][] { { 6 }, { 2, 15 }, { 1, 4, 10, 18 }, { null, null, null, null, 9, 12, 17, 19 } });

	}

	public void connect(TreeLinkNode root) {

		TreeLinkNode temp = root;

		while (temp != null) {

			TreeLinkNode temp1 = new TreeLinkNode(0);
			TreeLinkNode back = temp1;

			while (temp != null) {

				if (temp.left != null) {
					temp1.next = temp.left;
					temp1 = temp1.next;
				}

				if (temp.right != null) {
					temp1.next = temp.right;
					temp1 = temp1.next;
				}

				temp = temp.next;
			}

			temp = back.next;
		}
	}
}
