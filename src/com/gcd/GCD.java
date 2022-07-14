package com.gcd;

public class GCD {
	
	public static void main(String[] args) {
		System.out.println(new GCD().gcd(3, 8));
	}
	
	public int gcd(int A, int B) {

		if (B == 0)
			return A;

		return gcd(B, A % B);
	}
	
}
