package com.twoDarrays;

public class MatrixMulpication {

	public static void main(String[] args) {
		new MatrixMulpication().solve(new int[][] { { 94, 91 } },
				new int[][] { { 35, -52, -12, 26, -93, -61 }, { 29, -20, -36, -9, 66, 15 } });
	}

	public int[][] solve(int[][] A, int[][] B) {
		int[][] c = new int[A.length][B[0].length];

		for (int i = 0; i < c.length; i++) {

			for (int j = 0; j < c[0].length; j++) {
				int k = 0;
				while (k < A[0].length) {
					c[i][j] += A[i][k] * B[k][j];
					k++;
				}
			}

		}

		return c;
	}
}
