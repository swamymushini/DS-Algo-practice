package com.arrays;

public class MultipleRotArray {

	public static void main(String[] args) {
		solve(new int[] { 1, 2, 3, 4, 5 }, new int[] { 5, 3 });
	}

	static int[][] solve(int[] arr, int[] arrB) {

		int len = arr.length;

		int[][] matr = new int[arrB.length][arr.length];

		for (int i = 0; i < arrB.length; i++) {

			int B = arrB[i];

			B = B % len;

			int j = 0;

			int l = B;
			while (l < len) {
				matr[i][j++] = arr[l++];
			}
			l = 0;
			while (l < B) {
				matr[i][j++] = arr[l++];
			}

		}

		return matr;
	}

}
