package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode
				.buildTree(new Integer[][] { { 1 }, { 2, 3 }, { 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7, 8 } });

		System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder(root));
		;
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<TreeNode> qu = new Stack<TreeNode>();

		qu.add(A);

		boolean fwd = true;

		ArrayList<Integer> sub = new ArrayList<>();

		while (!qu.isEmpty() || !st.isEmpty()) {

			TreeNode poll = null;

			if (fwd) {
				poll = qu.pop();
				
				sub.add(poll.val);
				
				if (qu.isEmpty()) {
					fwd = false;
					res.add(new ArrayList<Integer>(sub));
					sub.clear();
				}
				
				if (poll.left != null)
					st.push(poll.left);

				if (poll.right != null)
					st.push(poll.right);
				
				
			} else {
				poll = st.pop();
				
				sub.add(poll.val);
				
				if (st.isEmpty()) {
					res.add(new ArrayList<Integer>(sub));
					sub.clear();
					fwd = true;
				}
				
				if (poll.right != null)
					qu.add(poll.right);

				if (poll.right != null)
					qu.add(poll.left);
				
			}

		

		}

		return res;
	}
}
