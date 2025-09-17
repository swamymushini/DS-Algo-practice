package com.trees;

import java.util.ArrayList;
import java.util.List;

import com.util.Util;

public class PrintAllPaths {

	public static void main(String[] args) {
		TreeNode buildTree = Util.buildTree(new Integer[][] { { 10 }, { -1, 5 }, { 5, 8, 4, 6 } });
		List<List<Integer>> pathSum = new PrintAllPaths().pathSum(buildTree);
		System.out.println(pathSum);
	}

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root) {

		ArrayList<Integer> arr = new ArrayList<>();

		if (root == null)
			return res;

		hasPathSum(root, null, null, false);
		return res;
	}

	public List<Integer> hasPathSum(TreeNode root, List<Integer> parent, List<Integer> child, boolean isLeft) {

		if (root == null)
			return null;

		if (root.left == null && root.right == null) {
			ArrayList<Integer> childs = new ArrayList<>();
			if (isLeft) {
				res.add(childs);
				childs.add(root.val);
				return childs;
			} else {
				child.add(root.val);
				return child;
			}
		}

		parent = new ArrayList<>();
		res.add(parent);
		parent.add(root.left.val);
		List<Integer> childs = hasPathSum(root.left, parent, null, true);

		parent.add(root.val);
		childs.add(root.val);

		hasPathSum(root.right, parent, childs, false);

		return childs;
	}

}
