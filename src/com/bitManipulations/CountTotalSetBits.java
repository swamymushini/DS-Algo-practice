package com.bitManipulations;

public class CountTotalSetBits {

	public static void main(String[] args) {
		System.out.println(new CountTotalSetBits().solve(1000000000));
	}

	long mod = (long) Math.pow(10, 9) + 7;

	public int solve(int A) {
		long sumOfSetBit = sumOfSetBit(A);
		sumOfSetBit %= mod;

		return (int) sumOfSetBit;
	}

	long sumOfSetBit(int A) {

		int n = A;

		int msb = 0;

		while (n != 0) {
			n >>= 1;
			msb++;
		}

		if (A == 0)
			return 0;

		if (A == 1)
			return 1;

		long x = (((long)1 << (msb - 2))) * (msb - 1);

		long diff = A - ((long)1 << (msb - 1)) + (long)1;

		long res = x + diff;

		return res + sumOfSetBit((int) diff - 1);
	}
}
