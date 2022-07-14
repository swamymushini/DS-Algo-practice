package com.strings;

public class PatternMatchingKMP {

	public static void main(String[] args) {
		int solve = new PatternMatchingKMP().solve("1001", "0011");
		System.out.println(solve);
	}

	public int solve(String A, String B) {

		StringBuilder sb = new StringBuilder();
		sb.append(A);
		sb.append("$");
		sb.append(B);
		sb.append(B.substring(0, B.length() - 1));

		int[] LPS = new LPSArray().calculateLPSArray(sb.toString());

		int cnt = 0;
		for (int i : LPS) {
			if (i == A.length())
				cnt++;
		}

		return cnt;
	}



}