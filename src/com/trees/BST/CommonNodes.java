package com.trees.BST;

import java.util.Stack;

import com.trees.TreeNode;
import com.util.Util;

public class CommonNodes {

	public static void main(String[] args) {
		int solve = new CommonNodes().solve(Util.getSampleBSTree(), Util.getSampleBSTree());
		System.out.println(solve);
	}

	public int solve(TreeNode A, TreeNode B) {
		
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		TreeNode curr1 = A;
		TreeNode curr2 = B;
		int mod = 1000000007;
		st1.push(curr1);
		curr1 = curr1.left;
		st2.push(curr2);
		curr2 = curr2.left;

		long sum = 0;

		while ((!st1.isEmpty() && !st2.isEmpty()) || (curr1 != null || curr2 != null)) {

			if (curr1 != null) {
				st1.push(curr1);
				curr1 = curr1.left;
			} else if (curr2 != null) {
				st2.push(curr2);
				curr2 = curr2.left;
			} else {
				curr1 = st1.peek();
				curr2 = st2.peek();
				if (curr1.val == curr2.val) {
					sum += (long) curr1.val;
					sum %= mod;
					st1.pop();
					st2.pop();
					curr1 = curr1.right;
					curr2 = curr2.right;
				} else if (curr1.val < curr2.val) {
					st1.pop();
					curr1 = curr1.right;
					curr2 = null;
				} else {
					st2.pop();
					curr2 = curr2.right;
					curr1 = null;
				}
			}
		}
		return (int) sum;
	}
}