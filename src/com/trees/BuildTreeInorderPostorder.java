package com.trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeInorderPostorder {

	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] A, int[] B) {

		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
		}

		return buildTree(A, B, 0, A.length - 1, 0, B.length - 1);
	}

	TreeNode buildTree(int[] in, int[] po, int sin, int ein, int spo, int epo) {

		if (sin > ein || spo > epo) {
			return null;
		}

		int ro = po[epo];
		TreeNode root = new TreeNode(ro);

		int idx = map.get(ro);

		int x = idx - sin;
		int y = spo + x - 1;

		root.left = buildTree(in, po, sin, idx - 1, spo, y);
		root.right = buildTree(in, po, idx + 1, ein, y + 1, epo - 1);

		return root;
	}
}
