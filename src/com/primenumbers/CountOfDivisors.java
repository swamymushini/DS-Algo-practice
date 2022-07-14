package com.primenumbers;

public class CountOfDivisors {

	public static void main(String[] args) {
		System.out.println(new CountOfDivisors().solve(new int[] { 1, 20 }));
	}

	public int[] solve(int[] A) {

		int max = 0;

		for (int i = 0; i < A.length; i++)
			max = Math.max(max, A[i]);

		int[] SPF = new int[max + 1];
		
		SPF[1] = -1;
		SPF[0] = -2;

		for (int i = 2; i * i <= max; i++) {

			for (int j = i * i; j <= max; j += i) {

				SPF[j] = SPF[j] + 1;

				if (j != i * i) 
					SPF[j] = SPF[j] + 1;
				

			}
		}

		for (int i = 0; i < A.length; i++)
			A[i] = SPF[A[i]] + 2;

		return A;
	}

}
