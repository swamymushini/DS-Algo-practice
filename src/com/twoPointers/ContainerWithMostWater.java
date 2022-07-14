package com.twoPointers;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		int solve = new ContainerWithMostWater().maxArea(new int[] { 1, 5, 4, 3 });

		System.out.println(solve);
	}
	
	public int maxArea(int[] A) {

		int l = 0;
		int r = A.length - 1;
		int max = Integer.MIN_VALUE;

		if (r == 0) {
			return 0;
		}

		while (l < r) {

			int sum = (r - l) * Math.min(A[r], A[l]);

			max = Math.max(sum, max);

			if (A[r] < A[l])
				r--;
			else if (A[l] < A[r])
				l++;
			else {
				l++;
				r--;
			}

		}

		return max;

	}
}
