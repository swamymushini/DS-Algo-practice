package com.twoPointers;

import java.util.Arrays;

public class PairsWithGivenDifference {

	public static void main(String[] args) {

		int cnt = new PairsWithGivenDifference().solve(new int[] { 8, 5, 1, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6,
				3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3, 21, 21 }, 3);

		System.out.println(cnt);
	}

	public int solve(int[] A, int B) {

		Arrays.sort(A);

		int l = 0, r = 1;
		int count = 0;

		while (l <= r && r < A.length) {

			if (r + 1 < A.length && A[r] == A[r + 1]) {
				r++;
				continue;
			}

			if (l + 1 < A.length && (A[l] == A[l + 1] && l + 1 != r)) {
				l++;
				continue;
			}

			if (r == l) {
				r++;
				continue;
			}

			int diff = A[r] - A[l];
			if (diff == B) {
				count++;
				l++;
				r++;
			} else if (diff < B) {
				r++;
			} else if (diff > B) {
				l++;
			}

		}

		return count++;
	}
}
