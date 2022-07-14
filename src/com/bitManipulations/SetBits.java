package com.bitManipulations;

public class SetBits {
	public long solve(long A, int B) {

		long i = 0;
		while (i < B) {

			A = (A | (1 << i));
			i--;
		}

		return A;
	}
}
