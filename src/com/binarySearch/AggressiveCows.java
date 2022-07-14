package com.binarySearch;

public class AggressiveCows {

	public static void main(String[] args) {
		System.out.println(new AggressiveCows().solve(new int[] { 1, 2, 3, 4, 5 }, 3));
	}

	public int solve(int[] A, int B) {

		int l = 1;
		int r = A[A.length - 1] - A[0];
		int ans = 0;

		while (l <= r) {

			int mid = (l + r) / 2;

			if (check(A, B, mid)) {
				l = mid + 1;
				ans = mid;
			} else {
				r = mid - 1;
			}

		}

		return ans;
	}

	boolean check(int[] A, int B, int tar) {

		int cow = 1;
		int i = 0;

		while (i+tar < A.length) {

			i = i + tar;
			cow++;
		}

		if (cow < B)
			return false;

		return true;
	}
}
