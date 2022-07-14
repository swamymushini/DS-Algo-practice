package com.Maths;

public class ModuloInverse {
	public int solve(int A, int M) {
		return new PowerFunction().pow(A, M - 2, M);
	}
}
