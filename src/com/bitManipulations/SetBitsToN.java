package com.bitManipulations;

public class SetBitsToN {

	public static void main(String[] args) {
		System.out.println(new SetBitsToN().solve(1000000000));
	}

	public int solve(int A) {

		long sumOfSetBit = sumOfSetBit(A);
		sumOfSetBit %= (Math.pow(10, 9) + 7);

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
		
		if (A == 2)
			return 2;
		

		long x = ((1 << (msb - 1)) / 2) * (msb - 1);
		x %= (Math.pow(10, 9) + 7);

		long diff = A - (1 << (msb - 1)) + 1;
		diff %= (Math.pow(10, 9) + 7);

		long res = x + diff;
		res %= (Math.pow(10, 9) + 7);
		
		res+=sumOfSetBit((int)diff - 1);
		res %= (Math.pow(10, 9) + 7);
		
		return res;
	}
}
