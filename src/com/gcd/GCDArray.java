package com.gcd;

public class GCDArray {

	public static void main(String[] args) {
		System.out.println(new GCDArray().solve(new int[] { 3, 9, 6, 8, 3 }));
	}

	public int solve(int[] A) {

		int g = new GCD().gcd(A[0], A[1]);

		for (int i = 2; i < A.length; i++) {

			g = new GCD().gcd(g, A[i]);

		}

		return g;
	}
}
