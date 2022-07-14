package com.bitManipulations;

import com.util.Util;

public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		System.out.println(new DifferentBitsSumPairwise().findSum(Util.generateMaxInput()));
	}

	public int findSum(int[] A) {

		for (int i = 0; i < A.length; i++) {
			
			if(i%1000==0) {
				System.out.println(" ");
			}
			
			System.out.print(A[i]);
			System.out.print(" ");
		}


		
		int sum = 0;
		int n = A.length;

		for (int i = 0; i < 32; i++) {

			int cnt = 0;

			for (int a : A) {

				if (checkBit(a, i)) {
					cnt++;
				}

			}

			sum += (int) (((long) cnt * (long) (n - cnt)) % (long) (Math.pow(10, 9) + 7));
			sum = sum % (int) (Math.pow(10, 9) + 7);
		}
		sum = sum % (int) (Math.pow(10, 9) + 7);

		return 2 * sum;
	}

	public boolean checkBit(int num, int i) {
		return ((num >> i) & 1) == 1;
	}
}
