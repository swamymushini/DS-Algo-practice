package com.arrays;

public class RangeSumQuery {
	public long[] rangeSum(int[] arr, int[][] B) {

		long[] res = new long[B.length];

		int ln = arr.length;

		long[] pref = new long[ln];

		pref[0] = arr[0];

		for (int i = 1; i < ln; i++) {

			pref[i] = arr[i] + pref[i - 1];

		}

		for (int i = 0; i < B.length; i++) {

			int l = B[i][0];
			int r = B[i][1];
			l--;
			r--;
			if (l == 0) {
				res[i] = pref[r];
				continue;
			}

			res[i] = pref[r] - pref[l - 1];
		}

		return res;
	}
}
