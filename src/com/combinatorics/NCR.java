package com.combinatorics;

public class NCR {

	public static void main(String[] args) {
		System.out.println(new NCR().solve2(5, 2, 13));
	}

	public int solve(int n, int r, int m) {

		if (n == r || r == 0)
			return 1;

		if (r == 1)
			return n;

		int res = solve(n - 1, r, m) % m + solve(n - 1, r - 1, m) % m;

		return res % m;
	}

	public int solve2(int n, int r, int m) {

		int arr[][] = new int[n + 1][r + 1];

		for (int i = 0; i <= r; i++) {

			for (int j = i; j <= n; j++) {

				if (i == 0)
					arr[j][i] = 1;
				else {
					arr[j][i] = (arr[j - 1][i]) % m + (arr[j - 1][i - 1]) % m;
					arr[j][i] = arr[j][i] % m;
				}
			}
		}
		return arr[n][r];
	}

}