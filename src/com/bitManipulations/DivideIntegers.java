package com.bitManipulations;

public class DivideIntegers {

	public static void main(String[] args) {
		System.out.println(new DivideIntegers().divide(48, 7));
	}

	public long divide(long A, long B) {

		if (A == (1 << 31) && B == -1)
			return (1 << 31) - 1;

		boolean pov = (A < 0 && B < 0) || (A > 0 && B > 0);

		A = Math.abs(A);
		B = Math.abs(B);

		if (A == 0)
			return 0;

		int i = 0;
		int cnt = 0;

		while ((A - (1 << i) * B) >= 0) {

			A = A - (1 << i) * B;
			
			cnt=cnt+1;
			
			i++;
			
			while ((A - (1 << i) * B) >= 0) {
				A = A - (1 << i) * B;
				cnt=cnt+(1 << i);
				i++;
			}
			
			i=0;
		}

		return pov ? cnt : -cnt;
	}
}
