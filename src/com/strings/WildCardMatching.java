package com.strings;

public class WildCardMatching {

	public static void main(String[] args) {

		String s = "adceb";
		String p = "*a*b";
		
		System.out.println(new WildCardMatching().isMatch(s, p));
//		System.out.println(new WildCardMatching().isMatch2(s, p));

	}

	public boolean isMatch(String s, String p) {
		return isMatch(p, s, p.length()-1, s.length()-1);
	}

	public boolean isMatch(String pattern, String text, int i, int j) {

		if (i < 0 && j < 0)
			return true;
		if (i < 0 && j >= 0)
			return false;
		else if (j < 0 && i >= 0) {
			for (int ii = i; ii < i; ii++) {
				if (pattern.charAt(ii) != '*')
					return false;
			}

			return true;
		}

		char pat = pattern.charAt(i);

		if (pat == '?' || pat == text.charAt(j))
			return isMatch(pattern, text, i - 1, j - 1);

		if (pat == '*')
			return isMatch(text, pattern, i - 1, j - 1) || isMatch(text, pattern, i, j - 1);

		return false;
	}

	public boolean isMatch2(String s, String p) {
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp[0].length - 1)
					dp[i][j] = true;
				else if (i == dp.length - 1)
					dp[i][j] = false;
				else if (j == dp[0].length - 1) {
					if (p.charAt(i) == ' ')
						dp[i][j] = dp[i + 1][j];
					else
						dp[i][j] = false;
				} else {
					if (p.charAt(i) == '?')
						dp[i][j] = dp[i + 1][j + 1];
					else if (p.charAt(i) == ' ') {
						dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
					} else {
						if (p.charAt(i) == s.charAt(j)) {
							dp[i][j] = dp[i + 1][j + 1];
						} else
							dp[i][j] = false;
					}
				}
			}
		}

		return dp[0][0];
	}
}