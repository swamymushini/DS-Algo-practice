
package com.trees;

public class LCA {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(
				new Integer[][] { { 3 }, { 5, 1 }, { 6, 2, 0, 8 }, { null, null, 7, 4, null, null, null, null } });

		System.out.println(new LCA().lowestCommonAncestor(root, new TreeNode(6), new TreeNode(4)).val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case: If root is null or matches either p or q, return root
		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		}

		// Recur for left and right subtrees
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// If both sides return non-null, root is the LCA
		if (left != null && right != null) {
			return root;
		}

		// Otherwise, return the non-null child
		return left != null ? left : right;
	}
}
