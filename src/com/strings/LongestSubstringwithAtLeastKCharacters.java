package com.strings;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtLeastKCharacters {

	public static void main(String[] args) {
		System.out.println(new LongestSubstringwithAtLeastKCharacters().longestSubstring("aaabb", 3));
	}

	public int longestSubstring(String s, int k) {

		if (s == null || s.length() == 0 || s.equals("") || s.length() < k)
			return 0;

		Map<Character, Integer> map = new HashMap<>();
		int res = 0;

		int n = s.length();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.compute(c, (key, v) -> v == null ? 1 : v + 1);
		}

		int i = 0;
		boolean breaked = false;
		while (i < n) {

			char c = s.charAt(i);

			if (map.get(c) < k) {
				breaked = true;
				break;
			}

			i++;
		}

		if (!breaked)
			return n;

		int ls1 = longestSubstring(s.substring(0, i), k);
		int ls2 = longestSubstring(s.substring(i + 1, n), k);

		res = Math.max(ls1, ls2);

		return res;
	}
}