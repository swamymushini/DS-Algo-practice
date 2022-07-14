package com.bitManipulations;

public class ReverseBits {
	
	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverse(3));
	}

	public long reverse(long a) {

		long res = 0;

		long i = 0;
		while (i < 32) {

			if (checkBit(a, i)) {
				res = setBit(res, 31 - i);
			}
			i++;
		}

		return res;
	}

	private boolean checkBit(long num, long pos) {
		return ((num >> pos) & 1) == 1;
	}

	private long setBit(long num, long pos) {
		return (num | ( new Long(1) << pos));
	}
}
