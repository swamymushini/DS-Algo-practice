package com.dp;

import com.util.Util;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println("");
		String s1 = "horse";
		String s2 = "ros";
		Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];

		int editDistance = new EditDistance().editDistance(s1, s2, s1.length(), s2.length(), dp);

		System.out.println(editDistance);

		Util.print2DArray(dp);

	}

//	abc,
//	abdc

	public int editDistance(String s1, String s2, int i, int j, Integer[][] dp) {

		if (dp[i][j] != null)
			return dp[i][j];

		if (i >= s1.length()) {
			return s2.length() - j;
		}

		if (j >= s2.length()) {
			return s1.length() - j;
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			dp[i][j] = editDistance(s1, s2, i + 1, j + 1, dp);
			return dp[i][j];
		}

		// insert
		int insert = 1 + editDistance(s1, s2, i, j + 1, dp);

		// delete
		int delete = 1 + editDistance(s1, s2, i + 1, j, dp);

		// replace
		int replace = 1 + editDistance(s1, s2, i + 1, j + 1, dp);

		dp[i][j] = Math.min(insert, Math.min(replace, delete));

		return dp[i][j];
	}

}
