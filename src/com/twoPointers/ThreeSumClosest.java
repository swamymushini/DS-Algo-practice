package com.twoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {

		int solve = new ThreeSumClosest().threeSumClosest(new int[] { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 }, -1);

		System.out.println(solve);

	}

	public int threeSumClosest(int[] A, int B) {

		Arrays.sort(A);

		int res = 0;
		int min = Integer.MAX_VALUE;

		int i = 0;
		int n = A.length;

		while (i < n - 2) {

			int j = i + 1;
			int k = n - 1;

			while (j < k) {

				int minDiff = Math.abs(A[k] + A[j] + A[i] - B);
				int sum = A[k] + A[j] + A[i];

				if (minDiff < min) {
					res = sum;
					min = minDiff;
				} else if (minDiff == 0) {
					res = B;
					break;
				}

				if (sum < B)
					j++;
				else
					k--;

			}

			i++;

		}

		return res;
	}
}
