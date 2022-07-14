package com.twoPointers;

import com.util.Util;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int[] solve = new SubarrayWithGivenSum().solve(new int[] { 15, 2, 5, 6, 9 }, 11);
		Util.printArray(solve);
	}

	public int[] solve(int[] A, int B) {

		int l = 0;
		int r = 1;

		int pref[] = new int[A.length];
		pref[0] = A[0];

		for (int i = 1; i < A.length; i++) 
			pref[i] = A[i] + pref[i - 1];


		int sum = 0;

		while (l <= r && r < A.length) {

			if (l == 0)
				sum = pref[r];
			else
				sum = pref[r] - pref[l - 1];

			if (sum == B)
				return prepareArray(l, r, A);
			else if (sum < B)
				r++;
			else
				l++;

		}

		return new int[] { -1 };
	}

	int[] prepareArray(int l, int r, int[] A) {

		int res[] = new int[r - l + 1];
		int i = 0;
		while (l <= r) {
			res[i++] = A[l++];
		}

		return res;
	}
}
