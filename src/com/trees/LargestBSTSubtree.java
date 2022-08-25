package com.trees;

public class LargestBSTSubtree {

	public static void main(String[] args) {
		TreeNode root = TreeNode.buildTree(new Integer[][] { { 25 }, { 7, 36 }, { 10, 22, 30, 40 },
				{ 5, 12, null, null, 28, 32, 38, 48 }, {}, {} });
		System.out.println(new LargestBSTSubtree().solve(root));
	}

	public int solve(TreeNode A) {
		return isBST(A).count + 1;
	}

	class TreeInfo {
		int min;
		int max;
		boolean isBST;
		int count = 0;

		TreeInfo(int min, int max, boolean isBST, int count) {
			this.min = min;
			this.max = max;
			this.isBST = isBST;
			this.count = count;
		}

	}

	public TreeInfo isBST(TreeNode A) {

		if (A == null)
			return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, true, -1);

		TreeInfo l = isBST(A.left);
		TreeInfo r = isBST(A.right);

		int val = A.val;

		int mini = Math.min(A.val, l.min);
		int maxi = Math.max(A.val, r.max);

		if (val > l.max && val <= r.min && r.isBST && l.isBST) {
			int count = r.count + l.count;
			return new TreeInfo(mini, maxi, true, count + 2);
		}

		return new TreeInfo(mini, maxi, false, Math.max(r.count, l.count));
	}
}
