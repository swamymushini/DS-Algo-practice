package com.binarySearch;

public class AthMagicalNumber {

	public static void main(String[] args) {
		System.out.println(new AthMagicalNumber().solve(807414236, 3788, 38141));
	}

	public int solve(int A, int B, int C) {

		long lcm = ((long) B * C) / (gcd(B, C));

		int mod = (int) Math.pow(10, 9) + 7;

		long r = Math.min(B, C) * (long) A;

		long l = Math.min(B, C);

		long ans = l;

		while (l <= r) {

			long mid = (l + r) / 2;

			long countB = mid / B;
			long countC = mid / C;
			long commonFactors = mid / lcm;
			long val = countMultiples(mid, B, C, lcm);
			

			if (val >= A) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;

		}

		if (ans < 0) 
			ans += mod;
		
		return (int) (ans % mod);

	}

	long countMultiples(long x, int B, int C, long lcm) {

		return x / B + x / C - x / lcm;

	}

	public int gcd(int A, int B) {

		if (B == 0)
			return A;

		return gcd(B, A % B);
	}

}
