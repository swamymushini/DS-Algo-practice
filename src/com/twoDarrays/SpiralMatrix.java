package com.twoDarrays;

public class SpiralMatrix {

	public static void main(String[] args) {
		new SpiralMatrix().generateMatrix(2);
		new SpiralMatrix().generateMatrix(3);
		new SpiralMatrix().generateMatrix(4);
		new SpiralMatrix().generateMatrix(5);
		new SpiralMatrix().generateMatrix(6);
		new SpiralMatrix().generateMatrix(7);

		System.out.println(new MinDaigonalSum().solve(new SpiralMatrix().generateMatrix(8)));
		
		
	}

	int val = 0;

	public int[][] generateMatrix(int A) {

		int[][] res = new int[A][A];

		val = A * A;

		int v = 1;

		int i = 0;

		int n = A - 1;

		while (n >= 1) {

			int k = i;
			int l = i;

			while (l <= n) {

				res[k][l++] = v++;
			}

			k = k + 1;
			l = n;

			while (k <= n) {
				res[k++][l] = v++;
			}

			k = n;
			l = k - 1;

			while (l >= i) {
				res[k][l--] = v++;
			}

			k = n - 1;
			l = i;

			while (k > i) {

				res[k--][l] = v++;
			}

			i++;
			n = n - 1;

		}

		return res;
	}

}
