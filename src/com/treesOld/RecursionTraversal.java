package com.treesOld;

import java.util.ArrayList;
import java.util.List;

public class RecursionTraversal<T> extends ITree<T> {

	@Override
	List<T> inOrderTraversal(TreeNode<T> a) {
		ArrayList<T> res = new ArrayList<>();
		inOrder(a, res);
		return res;
	}

	@Override
	List<T> preOrderTraversal(TreeNode<T> a) {
		ArrayList<T> res = new ArrayList<>();
		preOrder(a, res);
		return res;
	}

	@Override
	List<T> postOrderTraversal(TreeNode<T> a) {
		ArrayList<T> res = new ArrayList<>();
		postOrder(a, res);
		return res;
	}

	private void inOrder(TreeNode<T> A, List<T> res) {

		if (A == null)
			return;

		inOrder(A.left, res);
		res.add(A.val);
		inOrder(A.right, res);

	}

	private void preOrder(TreeNode<T> A, List<T> res) {

		if (A == null)
			return;

		res.add(A.val);
		preOrder(A.left, res);
		preOrder(A.right, res);
	}

	private void postOrder(TreeNode<T> A, List<T> res) {

		if (A == null)
			return;

		postOrder(A.left, res);
		postOrder(A.right, res);
		res.add(A.val);
	}

}
