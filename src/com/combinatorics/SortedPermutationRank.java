package com.combinatorics;

import java.util.HashSet;
import java.util.Set;

public class SortedPermutationRank {

	public static void main(String[] args) {
		System.out.println(new SortedPermutationRank().findRank("bbbbaaaa"));
	}

	public int findRank(String A) {

		long res = 0;

		int mod = 1000003;

		int[] letters = new int[128];

		int[] fact = new int[A.length() + 1];

		Set<Character> set = new HashSet<>();

		for (int i = 0; i < A.length(); i++) {

			char c = A.charAt(i);

			letters[(int) c - 1] = 1 + letters[(int) c - 1];
			set.add(c);
		}

		fact[1] = 1;
		fact[0] = 1;

		for (int i = 2; i <= A.length(); i++)
			fact[i] = (int) ((long) fact[i - 1] * i) % mod;

		int pos = set.size() + 1;

		for (int i = 0; i < A.length(); i++) {

			if (pos > 1)
				pos--;

			char c = A.charAt(i);

			int cnt = traverse(letters, c);

			res = ((long) fact[pos - 1] * cnt) % mod + res;

			res %= mod;

		}

		return (int) res + 1;
	}

	public int traverse(int[] let, char c) {

		int cnt = 0;

		for (int i = 0; i < let.length; i++) {

			if (i == c - 1) {
				let[i] = let[i] - 1;
				break;
			}

			if (let[i] >= 1) {
				cnt += let[i];
			}
		}

		return cnt;

	}
}
