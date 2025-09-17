package com.trees;

import java.util.ArrayList;
import java.util.Stack;

import com.trees.BST.ValidateBST;
import com.util.Util;

public class InOrderTraversal {

	public static void main(String[] args) {

		TreeNode root = Util.getSampleBSTree();

		System.out.println(new ValidateBST().isValidBST(root));

//		new InOrderTraversal().inOrder(root, new ArrayList<Integer>());
		new InOrderTraversal().usingStack(root);

	}

	public void inOrder(TreeNode root, ArrayList<Integer> res) {

		if (root == null)
			return;

		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}

	private void usingStack(TreeNode node) {

		Stack<TreeNode> stack = new Stack<>();
		stack.add(node);

		TreeNode current = node;

		while (!stack.isEmpty()) {

			while (current.left != null) {
				stack.add(current.left);
				current = current.left;
			}

			TreeNode pop = stack.pop();
			System.out.println(pop.val);

			if (pop.right != null) {
				current = pop.right;
				stack.add(current);
			}
		}

	}

}
