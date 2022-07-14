package com.twoPointers;

import com.util.Util;

public class ClosestPairFromSortedArrays {

	public static void main(String[] args) {
		
		int[] solve = new ClosestPairFromSortedArrays().solve(new int[] {1, 2, 3, 4, 5},new int[] {2, 4, 6, 8},9);	
		
		Util.printArray(solve);
	}

	public int[] solve(int[] A, int[] B, int C) {

		int min = Integer.MAX_VALUE;

		int[] res = new int[2];

		int l = 0, r = B.length - 1;
		int a = 0, b = 0;

		while (l < A.length || r >= 0) {

			if (r >= 0)
				b = B[r];

			
				a = A[l];

			int sum = Math.abs(a + b - C);

			if (sum < min) {
				res[0] = a;
				res[1] = b;
				min = sum;
			}

			sum = a + b;

			if (sum < C)
				l++;
			else if (sum == C) {
				r--;
				
				if (l+1 < A.length)
					l++;
			} else
				r--;

		}

		return res;
	}

}
