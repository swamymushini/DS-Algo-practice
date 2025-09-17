package com.dp;

public class DistinctSubsequences {

	public static void main(String[] args) {
		String s = "bb", t = "aaaaaaaaaaaa";

		System.out.println(new DistinctSubsequences().numDistinct(s, t, 0, 0));
	}

	public int numDistinct(String s, String t, int i, int j) {

		if (i >= s.length() || j >= t.length())
			return 0;

		char c1 = s.charAt(i);
		char c2 = t.charAt(j);

		int count = 0;

		if (c1 == c2) {

			if (j == t.length() - 1)
				count = 1;

			count = count + numDistinct(s, t, i + 1, j + 1);

		}

		count = count + numDistinct(s, t, i + 1, j);

		return count;
	}

}
