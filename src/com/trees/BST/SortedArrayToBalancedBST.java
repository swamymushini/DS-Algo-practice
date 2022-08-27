package com.trees.BST;

import com.trees.TreeNode;

public class SortedArrayToBalancedBST {
	
	public TreeNode sortedArrayToBST(final int[] A) {
		return buildBBST(A, 0, A.length - 1);
	}

	TreeNode buildBBST(int[] A, int min, int max) {

		if (min < 0 || max >= A.length || min > max)
			return null;

		int mid = (min + max) / 2;

		TreeNode node = new TreeNode(A[mid]);

		node.left = buildBBST(A, min, mid - 1);
		node.right = buildBBST(A, mid + 1, max);

		return node;
	}
}
