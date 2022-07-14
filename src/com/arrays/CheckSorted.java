package com.arrays;

public class CheckSorted {

	public static void main(String[] args) {

		System.out.println(new CheckSorted().solve(new String[] { "ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo",
				"atyqz", "chmxy", "ccvgv", "ghtow" }, "nbpfhmirzqxsjwdoveuacykltg"));
	}

	public int solve(String[] A, String B) {

		int[] ranks = new int[26];

		for (int i = 0; i < 26; i++) {

			ranks[B.charAt(i) - 'a'] = i;

		}

		for (int i = 1; i < A.length; i++) {

			String prev = A[i - 1];

			String next = A[i];

			if (!checkSorted(prev, next, ranks)) {
				return 0;
			}

		}

		return 1;
	}

	public boolean checkSorted(String a, String b, int[] ranks) {

		int l1 = a.length();
		int l2 = b.length();

		if (ranks[a.charAt(0) - 'a'] > ranks[b.charAt(0) - 'a'])
			return false;

		if (ranks[a.charAt(0) - 'a'] < ranks[b.charAt(0) - 'a'])
			return true;

		for (int i = 1; i < Math.min(l1, l2); i++) {

			if (ranks[a.charAt(i) - 'a'] > ranks[b.charAt(i) - 'a'])
				return false;
			else if (ranks[a.charAt(0) - 'a'] < ranks[b.charAt(0) - 'a'])
				return true;

		}

		if (l1 > l2)
			return false;

		return true;
	}

}
