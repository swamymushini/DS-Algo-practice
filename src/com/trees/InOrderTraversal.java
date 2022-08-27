package com.trees;

import java.util.ArrayList;

import com.trees.BST.ValidateBST;
import com.util.Util;

public class InOrderTraversal {

	public static void main(String[] args) {

		TreeNode root = Util.getSampleBSTree();

		System.out.println(new ValidateBST().isValidBST(root));

		new InOrderTraversal().inOrder(root, new ArrayList<Integer>());
	}

	public void inOrder(TreeNode root,ArrayList<Integer> res) {

		if (root == null)
			return;

		inOrder(root.left,res);
		res.add(root.val);
		inOrder(root.right,res);
	}

}
