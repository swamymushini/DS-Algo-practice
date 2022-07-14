package com.recursion;

public class IsMagic {

	public static void main(String[] args) {
		System.out.println(new IsMagic().sum(640));
	}

	public int sum(int B) {
		
		int A = solve(B);

		if (A == 10)
			return 1;
		else if (A < 10)
			return 0;
		else
			return sum(A);

	}

	public int solve(int A) {

		if (A == 0) {
			return 0;
		}

		return A % 10 + solve(A / 10);
	}
}
