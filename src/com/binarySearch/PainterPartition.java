package com.binarySearch;

public class PainterPartition {

	public static void main(String[] args) {
		System.out.println(new PainterPartition().paint(1, 1000000, new int[] { 1000000, 1000000 }));
	}

	public int paint(int A, int B, int[] C) {

		long max = Integer.MIN_VALUE;
		long sum = 0;

		for (int i = 0; i < C.length; i++) {

			sum += (long) C[i];

			max = Math.max(C[i], max);
		}

		long l = max * B;
		long r = sum * B;
		long ans = 0;

		if (A >= C.length)
			return (int) l % 10000003;

		while (l <= r) {

			long mid = (l + r) / 2;

			if (check(A, B, C, mid)) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;

		}
		
		if (ans < 0)
			return 10000003 + (int) ans;
		
		ans= ans % 10000003;

		return (int) ans;
	}

	private boolean check(int A, int B, int[] C, long time) {

		long sum = 0;

		for (int i = 0; i < C.length; i++) {

			long val = (long) C[i] * B;

			if (sum + val > time) {
				A--;
				sum = 0;
			}

			if (A == 0)
				return false;

			sum += val;
		}

		return true;

	}

}
