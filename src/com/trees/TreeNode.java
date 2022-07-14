package com.trees;

public class TreeNode<T> {

	TreeNode<T> right;

	TreeNode<T> left;

	T val;

	public TreeNode(TreeNode<T> right, TreeNode<T> left, T val) {
		super();
		this.right = right;
		this.left = left;
		this.val = val;
	}

	public TreeNode(T val) {
		super();
		this.val = val;
	}
	
	

}
