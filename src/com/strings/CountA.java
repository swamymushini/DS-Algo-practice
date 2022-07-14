package com.strings;

public class CountA {

	public int solve(String A) {

		int res = 0;
		int n = A.length();

		for (int i = 0; i < n; i++) {

			if (A.charAt(i) == 'a')
				res++;

		}

		res = res * (res + 1) / 2;

		return res;
	}

}
