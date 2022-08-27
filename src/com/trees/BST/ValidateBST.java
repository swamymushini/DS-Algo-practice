package com.trees.BST;

import com.trees.TreeNode;

//range approach
public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 25 }, { 7, 36 }, { 10, 22, 30, 40 },
				{ 5, 12, null, null, 28, 32, 38, 48 }, {}, {} });
		System.out.println(new ValidateBST().isValidBST(root));
		System.out.println(new ValidateBST().isBST(root).isBST);
	}

	class TreeInfo {

		int max;
		int min;
		TreeNode node;
		boolean isBST;

		public TreeInfo(int min, int max, TreeNode node, boolean isBST) {
			super();
			this.max = max;
			this.min = min;
			this.node = node;
			this.isBST = isBST;
		}

	}

	public int isValidBST(TreeNode A) {
		boolean valid = checkBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return valid ? 1 : 0;
	}

	public boolean checkBST(TreeNode A, int min, int max) {

		if (A == null) {
			return true;
		}

		if (A.val >= min && A.val <= max) {

			return checkBST(A.left, min, A.val - 1) && checkBST(A.right, A.val + 1, max);
		}

		return false;
	}

	public TreeInfo isBST(TreeNode A) {

		if (A == null) {
			return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, null, true);
		}

		TreeInfo l = isBST(A.left);
		TreeInfo r = isBST(A.right);

		Integer val = A.val;
		
		int mini = Math.min(val, l.min);
		int maxi = Math.max(val, r.max);

		if (val > l.max && val <= r.min && r.isBST && l.isBST) {
			return new TreeInfo(mini, maxi, A, true);
		}

		return new TreeInfo(mini, maxi, A, false);
	}
}
