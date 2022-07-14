package com.binarySearch;

public class PeakElement {

	private static int solve;

	public static void main(String[] args) {
		solve = new PeakElement().solve(new int[] { 5, 17, 100, 11 });

		System.out.println(solve);
	}

	public int solve(int[] A) {

		int l = 0;

		int r = A.length - 1;

		if (r == 0) {
			return A[r];
		}

		if (A[0] > A[1]) {
			return A[0];
		} else if (A[r] > A[r - 1]) {
			return A[r];
		}

		while (l <= r) {

			int mid = (l + r) / 2;

			if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1])
				return A[mid];
			else if (A[mid + 1] > A[mid])
				l = mid + 1;
			else
				r = mid - 1;

		}

		return -1;

	}
}
