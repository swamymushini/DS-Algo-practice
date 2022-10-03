package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SerializeDeserialize {

	TreeNode root;

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);

		List<String> l = new ArrayList<>();
		while (!s.isEmpty()) {
			TreeNode t = s.pop();
			// If current node is NULL, store marker
			if (t == null) {
				l.add("-1");
			} else {
				// Else, store current node and recur for
				// its children
				l.add("" + t.val);
				s.push(t.right);
				s.push(t.left);
			}
		}
		return String.join(" ", l);
	}

	static int t;

	public static TreeNode deSerialize(String data) {
		if (data == "")
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		String[] values = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		q.add(root);
		for (int i = 1; i < values.length; i++) {
			TreeNode parent = q.poll();
			if (!values[i].equals("-1")) {
				TreeNode left = new TreeNode(Integer.parseInt(values[i]));
				parent.left = left;
				q.add(left);
			}
			if (!values[++i].equals("-1")) {
				TreeNode right = new TreeNode(Integer.parseInt(values[i]));
				parent.right = right;
				q.add(right);
			}
		}
		return root;
	}

	// A simple inorder traversal used for testing the
	// constructed tree
	static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

}
