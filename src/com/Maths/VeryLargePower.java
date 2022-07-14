package com.Maths;

public class VeryLargePower {

	public static void main(String[] args) {
		
		System.out.println(new VeryLargePower().solve(2, 27));
	}

	public int solve(int A, int B) {
		
		int mod = (int) (Math.pow(10, 9) + 7);

		long pow = 1;
		

		while (B != 1) {

			pow = ((long)pow%mod) * B;
			
			pow %= mod; 
			
			B--;
		}

		return pow(A, (int)pow, mod );

	}

	public int pow(int A, int B, int C) {

		if (B == 0)
			return 1;

		long res = pow(A, B / 2, C);

		res = getMod(res, C);

		long val = (res * res) % C;

		val = getMod(val, C);

		if (B % 2 == 1)
			val = val * A;

		val = getMod(val, C);

		return (int) val;
	}

	private long getMod(long A, int C) {

		if (A < 0) {
			return A + C;
		}

		return A % C;
	}

}
