package com.bitManipulations;

public class SingleNumber {
	public int singleNumber(final int[] A) {
		int res = 0;

		for (int a : A) {
			res ^= a;
		}

		return res;
	}

}
