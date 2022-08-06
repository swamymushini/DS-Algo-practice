package com.trees.old;

import java.util.List;
import java.util.Stack;

public class Test {

	ITree<String> tree;

	public static void main(String[] args) {
		new Test().TreeTraversalTest();
	}

	void TreeTraversalTest() {

		tree = new RecursionTraversal<String>();

		TreeNode<String> a = tree.createBinaryTree();

		List<String> inOrderTraversal = tree.postOrderTraversal(a);

		System.out.println(inOrderTraversal);

		TreeNode<String> b = new TreeNode<>(a.val);

		tree.copy(a, b);

		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();

		tree.pathToRoot(a, stack, "I");

		while (!stack.isEmpty())
			System.out.println(stack.pop().val);

	}

}
