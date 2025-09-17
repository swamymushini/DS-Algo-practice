package com.trees.BST;

import java.util.Stack;

import com.trees.TreeNode;
import com.util.Util;

/**
 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; left=null; right=null; } }
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 11 }, { 12, 12 }, { 3, 4, 3, 4 } });
		Util.printInOrder(root);
		System.out.println(new KthSmallestElement().kthsmallest(root, 5));
		System.out.println(new KthSmallestElement().usingStack(root, 5));

	}

	int res = 0;
	Integer k = 0;

	public int kthsmallest(TreeNode A, int B) {
		k = 8;
		inOrder(A);
		return res;
	}

	private void inOrder(TreeNode A) {

		if (A == null)
			return;

		inOrder(A.left);

		if (res == 0 && k == 1) {
			res = A.val;
			return;
		}

		k = k - 1;

		inOrder(A.right);
	}

	private int usingStack(TreeNode node, int k) {

		Stack<TreeNode> stack = new Stack<>();
		stack.add(node);

		TreeNode current = node;

		while (!stack.isEmpty()) {

			while (current.left != null) {
				stack.add(current.left);
				current = current.left;
			}

			TreeNode pop = stack.pop();

			if (--k == 0)
				return pop.val;

			if (pop.right != null) {
				current = pop.right;
				stack.add(current);
			}
		}

		return 0;
	}

}
