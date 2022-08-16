package com.trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeInorderPreorder {

	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] A, int[] B) {

		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
		}

		return buildTree(A, B, 0, A.length - 1, 0, B.length - 1);
	}

	TreeNode buildTree(int[] in, int[] po, int sin, int ein, int spr, int epr) {

		if (sin > ein || spr > epr) {
			return null;
		}

		int ro = po[epr];
		TreeNode root = new TreeNode(ro);

		int idx = map.get(ro);

		int x = idx - sin;
		int y = spr + x;

		root.left = buildTree(in, po, sin, idx - 1, spr+1, y);
		root.right = buildTree(in, po, idx + 1, ein, y + 1, epr);

		return root;
	}
}
