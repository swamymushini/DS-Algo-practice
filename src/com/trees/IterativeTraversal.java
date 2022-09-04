package com.trees;

import java.util.Stack;

import com.util.Util;

public class IterativeTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 11 }, { 6, 15 }, { 2, 9, 7, null } });

		new IterativeTraversal().postOrder(Util.getSampleBSTree());
		System.out.println();
		new PostOrderTraversal().postOrder(Util.getSampleBSTree());
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
	
	class TreeInfo{
		public TreeNode root;
		public int cnt = 0;
		
		 public TreeInfo(TreeNode root) {
			 this.cnt = 1;
			 this.root = root;
		 }
		 
		 
	}

	public void postOrder(TreeNode root) {

		TreeNode node = root;

		Stack<TreeInfo> st = new Stack<>();

		st.push(new TreeInfo(node));

		while (!st.isEmpty()) {
			
			while (node != null&&node.left != null) {
				st.push(new TreeInfo(node.left));
				node = node.left;
			}
			
			if(node != null&&node.right!=null) {
				st.push(new TreeInfo(node.right));
				node = node.right;
			}
			else {
				TreeInfo pop = st.pop();
				System.out.print(pop.root.val+" ");
				
				if(st.isEmpty())
					break;
				
				TreeInfo peek = st.peek();
				
				if(peek.cnt!=2&&peek.root.right!=null) {
					st.push(new TreeInfo(peek.root.right));
					node = peek.root.right;
					peek.cnt = 2;
				}else
					node = null;
			}
		}

	}

}
