package com.primenumbers;

public class TwoPrimeDivisors {

	public static void main(String[] args) {
		System.out.println(new TwoPrimeDivisors().solve(12));
	}

	public int solve(int A) {

		int[] SPF = new int[A + 1];

		SPF[1] = -1;
		SPF[0] = -2;
		
		for (int i = 2; i<=A; i++) {

			if (SPF[i] == 0)
				for (int j = i*2; j <= A; j += i)
					SPF[j] = SPF[j] + 1;

		}

		int cnt = 0;
		
		for (int i = 3; i < A; i++) {
			if (SPF[i] == 2)
				cnt++;
		}

		return cnt;

	}
}
