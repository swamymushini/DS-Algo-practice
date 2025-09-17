package com.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

	public static void main(String[] args) {
		int res = new CharacterReplacement().characterReplacement("AABABBA", 1);
		System.out.println(res);
	}

	public int characterReplacement(String s, int k) {

		int l = 0;
		int r = 0;

		int res = 0;

		HashMap<Character, Integer> map = new HashMap<>();

		while (r < s.length()) {

			char c = s.charAt(r);

			map.compute(c, (key, val) -> val == null ? 1 : val + 1);

			if (valid(map, r - l + 1, k)) {
				res = Math.max(r - l + 1, res);
				r++;
			} else {
				map.compute(s.charAt(l), (key, val) -> val - 1);
				l++;
			}

		}

		return res;

	}

	boolean valid(Map<Character, Integer> map, int len, int k) {

		int max = 0;

		for (Character ch : map.keySet()) {
			max = Math.max(map.get(ch), max);
		}

		return len - max <= k;
	}

}