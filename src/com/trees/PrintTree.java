package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
	public static void main(String[] args) {
		
		TreeNode root = TreeNode.buildTree(
				new Integer[][] { { 15 }, { 12, 20 }, { 9, 14, 16, 27 }, { 8, 10, null, null, null, null, 23, 29 } });
		
		new PrintTree().printTree(root);
	}

	public void printTree(TreeNode root) {

		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(root);
		qu.add(new TreeNode(null));
		
		int ht = getHeight(root)+1	;
		printSpaces(ht--);
		while (!qu.isEmpty()) {

			TreeNode poll = qu.poll();

			if (poll == null) {
				System.out.print(" ");
				continue;
			}

			if (poll.val == null) {
				if (!qu.isEmpty())
					qu.add(new TreeNode(null));
				System.out.println();
				printSpaces(--ht);
			} else {
				System.out.print(poll.val + " ");
				printSpaces(ht);
					qu.add(poll.left);
					qu.add(poll.right);
			}
		}

	}

	void printSpaces(int cnt){
		while(cnt-->0) {
		System.out.print(" ");
		}
	}

	public int getHeight(TreeNode root) {

		if (root == null)
			return -1;

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
