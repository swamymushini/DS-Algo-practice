package com.twoDarrays;

public class AntiDiagonals {

	public static void main(String[] args) {
		new AntiDiagonals().diagonal(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
	}

	public int[][] diagonal(int[][] A) {
		int n = A.length;
		int[][] res = new int[2 * n - 1][n];
		
		int k=0;
		int l=0;

		for (int i = 0; i < n; i++) {

			int x = 0;
			int j = i;

			while (x <= i) {
				
				res[k][l++] =A[x][j];
				
				x++;
				j--;
			}
			
			l=0;
			k++;

		}

		for (int i = 1; i < n; i++) {

			int x = i;
			int j = n-1;

			while (x <= n-1) {
				
				res[k][l++] =A[x][j];
				x++;
				j--;
			}
			l=0;
			k++;


		}

		return res;
	}
}
