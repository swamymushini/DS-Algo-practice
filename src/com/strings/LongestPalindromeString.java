package com.strings;

public class LongestPalindromeString {

	public static void main(String[] args) {
		String s1 = "FBCD123DCBF";
		String res = "";

		int k = 1;

		while (k < s1.length()) {
			String rs = checkPalindrome(k, s1);

			if (res.length() < rs.length())
				res = rs;

			k++;
		}

		System.out.println(res);
	}

	static String checkPalindrome(int j, String s) {
		String res = "";
		int i = j - 1;
		while (i >= 0 && j < s.length()) {

			if (s.charAt(i) == s.charAt(j)) {
				res = s.charAt(j) + res + s.charAt(i);
			} else
				return res;
			i--;
			j++;

		}

		return res;

	}

}