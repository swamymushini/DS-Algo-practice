package com.trees;

public class DistanceBtwNodes {

	public int solve(TreeNode A, int B, int C) {

		if (A == null)
			return 0;

		if (A.val == B || A.val == C) 
			return 0;

		if (A.val > B && A.val > C) {
			return solve(A.left, B, C);
		} else if (A.val < B && A.val < C)
			return solve(A.right, B, C);
		else {
			return solve(A.right, B, C) + solve(A.left, B, C) + 2;
		}
	}

}
