package com.gcd;

public class MaxGCDArray {

	public static void main(String[] args) {
		System.out.println(new MaxGCDArray().solve(new int[] { 12, 15, 24, 36 }));
	}

	public int solve(int[] A) {

		int g = gcd(A[0], A[1]);
		int min = Math.max(A[0], A[1]);
		int minGcd = g;

		for (int i = 2; i < A.length; i++) {

			g = gcd(g, A[i]);

			if (g < minGcd) {
				minGcd = g;
				min = A[i];
			}

		}

		g = gcd(A[0], A[1]);

		for (int i = 2; i < A.length; i++) {

			if (A[i] == min) {
				continue;
			}

			g = gcd(g, A[i]);

		}

		return g;
	}

	public int gcd(int A, int B) {

		if (B == 0)
			return A;

		return gcd(B, A % B);
	}
}
