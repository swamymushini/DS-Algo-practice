package com.twoPointers;

import com.util.Util;

public class AnotherCountRectangles {

	public static void main(String[] args) {

		int solve = new AnotherCountRectangles().solve(Util.generateMaxInput(), 91539550);

		System.out.println(solve);

	}

	public int solve(int[] A, int B) {

		int mod = (int) Math.pow(10, 9) + 7;
		long cnt = 0;
		int l = 0;
		int r = A.length - 1;

		if (A[0] == 2000) {
			System.out.println(B + " " + A.length + " " + A[A.length - 1]);
		}

		while (l <= r) {

			long prod = ((long) A[r]) % mod * ((long) A[l]) % mod;
			prod %= mod;

			if (prod < B) {

				long sum = r - l;
				sum = sum + sum;

				sum %= mod;

				cnt = cnt + 1 + sum;

				cnt %= mod;

				l++;
			} else
				r--;

		}

		return (int) cnt % mod;
	}
}
