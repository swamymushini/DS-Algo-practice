package com.arrays;

public class MaxSubArray {
	
	public static void main(String[] args) {
		System.out.println(new MaxSubArray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

	public int maxSubArray(int[] A) {
		int sum = A[0];
		int max = Integer.MIN_VALUE;

		int n = A.length;

		for (int i = 1; i < n; i++) {

			if (sum + A[i] < A[i]) {
				sum = A[i];
			} else {
				sum = A[i]+sum;
			}

			max = Math.max(sum, max);
		}
		return max;
	}

}