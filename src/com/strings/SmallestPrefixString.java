package com.strings;

public class SmallestPrefixString {

	public static void main(String[] args) {
		System.out.println(new SmallestPrefixString().smallestPrefix("ababa", "ahahahah"));
	}

	public String smallestPrefix(String A, String B) {

		int l = 1;
		int r = 0;

		while (l < A.length() && r < B.length()) {

			if (A.charAt(l) < B.charAt(r))
				l++;
			else {
				r++;
				break;
			}

		}

		if (r == 0)
			r++;

		String res = A.substring(0, l) + B.substring(0, r);

		return res;

	}

}
