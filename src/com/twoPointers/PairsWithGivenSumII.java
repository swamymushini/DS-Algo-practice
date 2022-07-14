package com.twoPointers;

public class PairsWithGivenSumII {

	public static void main(String[] args) {

		int cnt = new PairsWithGivenSumII().solve(new int[] { 2, 4, 4, 5, 6, 8, 10 }, 6);

		System.out.println(cnt);
	}

	public int solve(int[] A, int B) {

		int l = 0, r = A.length - 1;
		int cnt = 0;
		int mod = (int) Math.pow(10, 9) + 7;

		while (l < r) {

			int sum = A[l] + A[r];
			if (sum == B) {
				int l1 = A[l];
				int r1 = A[r];

				long cntl1 = 1;
				long cntr1 = 1;

				while (A[l + 1] == l1 ) {
					cntl1++;
					l++;
				}

				while (A[r - 1] == r1 ) {
					cntr1++;
					r--;
				}
				l++;
				r--;
				long res = 0;

				if (l1 == r1) {
					long tot = cntl1 + cntr1;
					tot %= mod;
					res = tot * (tot - 1) / 2;
				} else
					res = cntl1 * cntr1;

				res %= mod;
				cnt += (int) res;
			} else if (sum < B)
				l++;
			else
				r--;

		}

		return cnt % mod;
	}
}
