package com.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.util.Util;

public class ThreeSumZero {

	public static void main(String[] args) {
		int[][] solve = new ThreeSumZero()
				.threeSum(new int[] { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 });
		Util.print2DArray(solve);
	}

	public int[][] threeSum(int[] A) {

		Arrays.sort(A);

		Util.printArray(A);

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < A.length; i++) {

			int j = i + 1;
			int k = A.length - 1;

			while (j < k) {

				int sum = A[j] + A[k];

				if (sum == -A[i]) {

					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(A[i]);
					arr.add(A[j]);
					arr.add(A[k]);

					while ((A.length - j > 2) && A[j] == A[j + 1])
						j++;

					while (k > 1 && A[k] == A[k - 1])
						k--;

					res.add(arr);
					j++;
					k--;

				} else if (sum < -A[i]) {
					j++;
				} else
					k--;

			}

			while ((A.length - i > 2) && A[i] == A[i + 1])
				i++;

		}

		return Util.nestedListtoArray(res);

	}

}
