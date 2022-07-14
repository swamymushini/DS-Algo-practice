package com.gcd;

public class LargestCoprimeDivisor {

	public int cpFact(int A, int B) {

		while (gcd(A, B) != 1) {
			A /= gcd(A, B);
		}

		return A;
	}

	public int gcd(int A, int B) {

		if (B == 0)
			return A;

		return gcd(B, A % B);
	}

}
