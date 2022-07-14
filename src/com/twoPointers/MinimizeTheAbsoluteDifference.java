package com.twoPointers;

public class MinimizeTheAbsoluteDifference {

	public static void main(String[] args) {

		int min = new MinimizeTheAbsoluteDifference().solve(new int[] { 1, 4, 5, 8, 10 }, new int[] { 6, 9, 15 },
				new int[] { 2, 3, 6, 6 });

		System.out.println(min);
	}

	public int solve(int[] A, int[] B, int[] C) {

		int min = Integer.MAX_VALUE;

		int i = 0, j = 0, k = 0;

		while (i < A.length && j < B.length && k < C.length) {

			min = Math.min(Math.abs(max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])), min);

			int mint = min(A[i], B[j], C[k]);

			if (A[i] == mint) {
				i++;
			} else if (B[j] == mint) {
				j++;
			} else {
				k++;
			}

		}

		return min;
	}

	private int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	private int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

}
