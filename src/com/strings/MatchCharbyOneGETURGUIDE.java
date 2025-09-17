package com.strings;
import java.util.*;

class MatchCharbyOneGETURGUIDE {

	public static void main(String[] args) {

		String[] words = { "aab", "ada" };
		System.out.println(new MatchCharbyOneGETURGUIDE().solution(words));
	}

	public String solution(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		int K = words[0].length();
		if (K == 0) {
			return "";
		}

		for (int pos = 0; pos < K; pos++) {

			for (char c = 'a'; c <= 'z'; c++) {
				boolean isValid = true;
				String candidate = buildCandidate(words[0], pos, c);

				for (String word : words) {
					if (differsByMoreThanOne(candidate, word)) {
						isValid = false;
						break;
					}
				}

				if (isValid) {
					return candidate;
				}
			}
		}

		return "";
	}

	private String buildCandidate(String template, int pos, char c) {
		char[] chars = template.toCharArray();
		chars[pos] = c;
		return new String(chars);
	}

	private boolean differsByMoreThanOne(String s1, String s2) {
		int differences = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				differences++;
				if (differences > 1) {
					return true;
				}
			}
		}
		return false;
	}
}