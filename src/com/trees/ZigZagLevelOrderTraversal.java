package com.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode
				.buildTree(new Integer[][] { { 1 }, { 2, 3 }, { 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7, 8 } });

		System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder(root));

		System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder2(root));
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode A) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Deque<TreeNode> de = new LinkedList<TreeNode>();

		int i = 1;

		de.addFirst(new TreeNode(-1));
		de.addFirst(A);

		ArrayList<Integer> sub = new ArrayList<>();

		while (!de.isEmpty()) {

			if (i % 2 == 1) {

				TreeNode poll = de.pollFirst();

				if (poll.val == -1) {

					res.add(new ArrayList<Integer>(sub));
					sub.clear();

					if (de.peek() == null)
						break;

					i++;
					de.addFirst(new TreeNode(-1));
					continue;
				}

				sub.add(poll.val);

				if (poll.left != null)
					de.addLast(poll.left);

				if (poll.right != null)
					de.addLast(poll.right);
			} else {

				TreeNode poll = de.pollLast();

				if (poll.val == -1) {

					res.add(new ArrayList<Integer>(sub));
					sub.clear();

					if (de.peek() == null)
						break;

					de.addLast(new TreeNode(-1));
					i++;
					continue;
				}

				sub.add(poll.val);

				if (poll.right != null)
					de.addFirst(poll.right);

				if (poll.left != null)
					de.addFirst(poll.left);
			}

		}

		return res;
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
