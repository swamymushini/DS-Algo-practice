package com.arrays;

public class InterestingArray {

	public static void main(String[] args) {

		System.out.println(new InterestingArray().solve(new int[] { 1, 20, 14, 15 }));
	}

	public String solve(int[] A) {

		int cnt = 0;

		for (int i = 0; i < A.length; i++) {
			if (A.length % 2 != 0) {
				cnt++;
			}
		}

		if (cnt % 2 == 0) {
			return "Yes";
		}

		return "No";
	}
}
