package com.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
	}

	public String minWindow(String s, String t) {

		Map<Character, Integer> charMap = new HashMap<>();

		int i = 0;
		int j = 0;
		int len = Integer.MAX_VALUE;

		for (int k = 0; k < t.length(); k++) {
			char c = t.charAt(k);
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}

		int l = 0;
		int r = 0;
		int sum = t.length();

		while (l <= r && r < s.length()) {

			char end = s.charAt(r);

			if (charMap.containsKey(end)) {
				int val = charMap.get(end);
				val = val - 1;
				if (val >= 0)
					sum--;
				charMap.put(end, val);
			}

			while (l <= r && sum < 1) {
				int len2 = r - l + 1;
				System.out.println(s.substring(l, r + 1));
				if (len2 < len) {
					len = len2;
					i = l;
					j = r;
				}

				if (charMap.containsKey(s.charAt(l))) {
					int val = charMap.get(s.charAt(l));
					val = val + 1;
					charMap.put(s.charAt(l), val);
					if (val >= 1) {
						sum = sum + 1;
					}

				}

				l++;
			}

			r++;

		}

		if (len == Integer.MAX_VALUE) {
			return " ";
		}

		return s.substring(i, j + 1);
	}
}