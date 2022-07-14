package com.recursion;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
	
	public static void main(String[] args) {
		System.out.println(new RomantoInteger().intToRoman(8));
	}

	Map<Integer, String> map = new HashMap<>();

	public RomantoInteger() {
			map.put(1, "I");
			map.put(5, "V");
			map.put(10, "X");
			map.put(50, "L");
			map.put(100, "C");
			map.put(500, "D");
			map.put(1000, "M");
		}

	public String intToRoman(int num) {

		if (num <= 0)
			return "";

		if (num == 1)
			return "I";

		int prev = 0;

		for (Integer a : map.keySet()) {

			if (a > num) {

				num = num - prev;
				return map.get(prev) + intToRoman(num);
			}

			prev = a;
			System.out.println(prev);

		}

		return "";
	}

}
