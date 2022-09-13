package com.trees;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 1 }, { 2, 3 }, { 4, 5, 6, 7 } });
		System.out.println(new LeastCommonAncestor().lca(root, 5, 7));
	}

	public int lca(TreeNode root, int B, int C) {
		
		TreeNode lca = new LeastCommonAncestor().LCA(root, B, C);
		if (lca == null)
			return -1;
		else if (find(root, B) && find(root, C))
			return lca.val;
		else
			return -1;
	}

	public TreeNode LCA(TreeNode A, int B, int C) {

		if (A == null)
			return null;

		if (A.val == B || A.val == C)
			return A;

		TreeNode left = LCA(A.left, B, C);
		TreeNode right = LCA(A.right, B, C);

		if (left != null && right != null)
			return A;
		else if (left == null)
			return right;
		else
			return left;
	}

	public boolean find(TreeNode A, int val) {

		if (A == null)
			return false;

		if (A.val == val)
			return true;

		return find(A.left, val) || find(A.right, val);
	}
}