package com.trees;

public class BSTOneChild {
	public String solve(int[] A) {

		int lmin = Integer.MIN_VALUE;
		int lmax = A[0] - 1;
		int rmin = A[0];
		int rmax = Integer.MAX_VALUE;

		for (int i = 1; i < A.length; i++) {

			int val = A[i];

			if (val >= lmin && val <= lmax) {
				rmax = lmax;
				lmax = val - 1;
				rmin = val;
				continue;
			}

			if (val >= rmin && val <= rmax) {
				lmin = rmin;
				lmax = val - 1;
				rmin = val;
				continue;
			}

			return "NO";
		}

		return "YES";
	}
}