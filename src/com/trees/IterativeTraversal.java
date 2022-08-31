package com.trees;

import java.util.Stack;

public class IterativeTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 11 }, { 6, 15 }, { 2, 9, 7, null } });

		new IterativeTraversal().postOrder(root);
		System.out.println();
//		new PostOrderTraversal().postOrder(Util.getSampleBSTree());
	}

	public void preOrder(TreeNode root) {

		TreeNode node = root;

		Stack<TreeNode> st = new Stack<>();

		st.push(node);

		while (!st.isEmpty()) {

			while (node != null) {

				System.out.print(node.val + " ");

				if (node.left == null)
					break;

				st.push(node.left);
				node = node.left;
			}

			TreeNode pop = st.pop();

			if (pop.right != null)
				st.push(pop.right);

			node = pop.right;

		}
	}

	public void inOrder(TreeNode root) {

		TreeNode node = root;

		Stack<TreeNode> st = new Stack<>();

		st.push(node);

		while (!st.isEmpty()) {

			while (node != null) {

				if (node.left == null)
					break;

				st.push(node.left);
				node = node.left;
			}

			TreeNode pop = st.pop();

			System.out.print(pop.val + " ");

			if (pop.right != null)
				st.push(pop.right);

			node = pop.right;

		}

	}

	public void postOrder(TreeNode root) {

		TreeNode node = root;

		Stack<TreeNode> st = new Stack<>();

		st.push(node);

		while (!st.isEmpty()) {
			
			while (node != null&&node.left != null) {
				st.push(node.left);
				node = node.left;
			}
			
			if(node.right!=null) {
				st.push(node.right);
				node = node.right;
			}
			else {
				TreeNode pop = st.pop();
			}
		}

	}

}
