package com.binarySearch;

import com.util.Util;

public class SpecialInteger {

	public static void main(String[] args) {
		System.out.println(new SpecialInteger().solve(Util.generateMaxInput(), 100000));

	}

	public int solve(int[] A, int B) {

		int l = 1;
		int r = A.length;
		int ans = 0;

		while (l <= r) {

			int mid = (l + r) / 2;

			if (checkSum(mid, A, B)) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}

		return ans;
	}

	boolean checkSum(int k, int[] A, int tar) {

		int sum = 0;
		int i = 0;

		for (i = 0; i < k; i++)
			sum += A[i];

		if (sum > tar)
			return false;

		while (i < A.length) {

			sum = sum + A[i] - A[i - k];

			if (sum > tar)
				return false;

			i++;
		}

		return true;
	}

}
