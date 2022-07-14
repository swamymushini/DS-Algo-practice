package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	Map<String, Integer> map = new HashMap<>(); 

	public RomanToInteger() {
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
	}

	public int romanToInt(String s) {
		int res = 0;

		for (int i = s.length() - 1; i >= 0; i--) {

			char c = s.charAt(i);

			if (i != 0) {
				String val = String.valueOf(s.charAt(i - 1) + "" + c);
				if (map.containsKey(val)) {
					res = map.get(val) + res;
					i--;
					continue;
				}
			}

			res = map.get(String.valueOf(c)) + res;
		}

		return res;
	}
}