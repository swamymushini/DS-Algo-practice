package com.arrays;

public class MaxSubArrayLmt {

	public static void main(String[] args) {
		System.out.println(new MaxSubArrayLmt().maxSubarray(5, 12, new int[] { 2, 1, 3, 4, 5 }));
	}

	public int maxSubarray(int C, int B, int[] A) {

		int sum = 0;
		int max = 0;

		int n = A.length;

		for (int i = 0; i < n; i++) {

			for (int j = i; j < n; j++) {

				sum += A[j];

				if (sum <= B) {
					max = Math.max(max, sum);
				} else
					break;
			}
			sum = 0;

		}

		return max;

	}

}
