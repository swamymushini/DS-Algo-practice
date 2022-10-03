package com.trees.BST;

import java.util.Stack;

import com.trees.TreeNode;
import com.util.Util;

public class CommonNodes {

	public static void main(String[] args) {
		TreeNode A = Util.deSerialize(
				"25 18 30 14 21 28 33 6 17 20 22 27 29 31 43 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1");

		TreeNode B = Util.deSerialize(
				"18 11 24 6 14 21 28 4 7 12 16 19 22 25 31 -1 5 -1 9 -1 13 15 17 -1 20 -1 23 -1 26 30 34 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1");

//		TreeNode A = Util.buildTree(new Integer[][] { { 25 }, { 18, 30 }, { 14, 21, 28, 33 } });
//		TreeNode B = Util
//				.buildTree(new Integer[][] { { 18 }, { 11, 24 }, { 6, 14, 21, 28 }, { 4, 7, 12, 16, 19, 22, 25, 31 } });

		System.out.println(new CommonNodes().morrisAlgo(A, B));
//		System.out.println(new CommonNodes().solve(A, B));
	}

	public int morrisAlgo(TreeNode A, TreeNode B) {

		TreeNode curr1 = A;
		TreeNode curr2 = B;
		long sum = 0;
		int mod = (int) (Math.pow(10, 9) + 7);

		boolean c1 = true, c2 = true;

		while (curr1 != null && curr2 != null) {

			if (c1 && curr1.left != null) {

				TreeNode temp = curr1.left;
				while (temp.right != null && temp.right != curr1)
					temp = temp.right;

				if (temp.right == null) {
					temp.right = curr1;
					curr1 = curr1.left;
				} else {
					temp.right = null;
					c1 = false;
				}
			} else if (c2 && curr2.left != null) {

				TreeNode temp = curr2.left;
				while (temp.right != null && temp.right != curr2)
					temp = temp.right;

				if (temp.right == null) {
					temp.right = curr2;
					curr2 = curr2.left;
				} else {
					temp.right = null;
					c2 = false;
				}

			} else {
				TreeNode temp1 = curr1;
				TreeNode temp2 = curr2;

				if (temp1.val == temp2.val) {
					
					sum += (long) temp1.val;
					sum %= mod;
					curr1 = curr1.right;
					curr2 = curr2.right;
					c2 = true;
					c1 = true;
				} else if (temp1.val < temp2.val) {
					c1 = true;
					curr1 = curr1.right;
				} else {
					c2 = true;
					curr2 = curr2.right;
				}
			}
		}

		return (int)sum;
	}

	int compare(TreeNode temp1, TreeNode temp2) {

		if (temp1.val == temp2.val) {
			Integer val = temp1.val;
			temp1 = temp1.right;
			temp2 = temp2.right;
			return val;
		} else if (temp1.val < temp2.val) {
			temp1 = temp1.right;
		} else {
			temp2 = temp2.right;
		}
		return 0;
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