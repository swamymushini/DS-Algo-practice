package com.binarySearch;

public class SquareRootOfInteger {

	public static void main(String[] args) {
		System.out.println(new SquareRootOfInteger().sqrt(2147395600));

	}

	public int sqrt(int A) {

		int l = 1;
		int r = A;
		int res = 0;

		while (l <=r) {

			int mid = (l + r) / 2;
			long val = (long)mid * mid;

			if (val == A) {
				return mid;
			} else if (val > A)
				r = mid - 1;
			else {
				res = mid;
				l = mid + 1;
			}

		}

		return res;

	}

}
