package com.arrays;

public class SubsequencesAG {
	public int solve(String A) {

		int b = 0;
		int c = 0;

		for (int i = A.length() - 1; i >= 0; i--) {

			if (A.charAt(i) == 'G') {
				b++;
			}

			if (A.charAt(i) == 'A') {
				c = c + b;
			}

		}

		return c;
	}
}
