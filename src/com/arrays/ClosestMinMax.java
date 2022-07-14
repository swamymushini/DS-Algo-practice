package com.arrays;

public class ClosestMinMax {

	public static void main(String[] args) {
		System.out.println(new ClosestMinMax().solve(new int[] { 814, 761, 697, 483, 981 }));
	}

	public int solve(int[] A) {

		int min = A[0];
		int max = A[0];
		int dist = A.length;

		for (int i = 0; i < A.length; i++) {
			min = Math.min(A[i], min);
			max = Math.max(A[i], max);
		}

		int minInd = -1;
		int maxInd = -1;

		for (int i = 0; i < A.length; i++) {

			if (A[i] == min) {
				minInd = i;
				
				if(maxInd>=0)
					dist = Math.min(dist, Math.abs(minInd - maxInd + 1));
			}

			if (A[i] == max) {
				maxInd = i;
				
				if(minInd>=0)
					dist = Math.min(dist, Math.abs(minInd - maxInd + 1));
			}

		}

		return dist;
	}
}
