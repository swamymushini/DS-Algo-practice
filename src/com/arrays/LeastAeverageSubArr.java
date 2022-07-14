package com.arrays;

public class LeastAeverageSubArr {

	public static void main(String[] args) {
		System.out.println(new LeastAeverageSubArr().solve(new int[] { 20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11 }, 9));
	}

	public int solve(int[] A, int B) {
		double sum = 0;

		for (int i = 0; i < B; i++) {
			sum = sum + A[i];
		}

		double min = sum / B;
		int minInd = 0;

		for (int i = 1; i <= A.length - B; i++) {
			sum = sum - A[i - 1] + A[i + B - 1];

			if ((sum / B) < min) {
				minInd = i;
				min = sum / B;
			}

		}

		return minInd;
	}

}
