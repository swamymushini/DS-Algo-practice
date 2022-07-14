package com.arrays;

public class ChristmasTrees {

	public static void main(String[] args) {
		System.out.println(new ChristmasTrees().solve(new int[] { 5, 9, 10, 4, 7, 8 }, new int[] { 5, 6, 4, 7, 2, 5 }));
	}

	public int solve(int[] A, int[] B) {

		int res = Integer.MAX_VALUE;

		int n = A.length;

		boolean noMinFound = true;
		for (int i = 1; i < n - 1; i++) {

			int j = i - 1;
			int lmin = Integer.MAX_VALUE;
			int rmin = Integer.MAX_VALUE;

			while (j >= 0) {

				if (A[j] < A[i] && B[j] < lmin) {
					lmin = B[j];
				}

				j--;
			}

			j = i + 1;

			while (lmin != Integer.MAX_VALUE && j < n) {

				if (A[j] > A[i] && B[j] < rmin) {
					rmin = B[j];
				}

				j++;
			}

			if (lmin != Integer.MAX_VALUE && rmin != Integer.MAX_VALUE) {
				res = Math.min(res, lmin + rmin + B[i]);
				noMinFound = false;
			}

		}

		if (noMinFound) {
			return -1;
		}

		return res;

	}
}
