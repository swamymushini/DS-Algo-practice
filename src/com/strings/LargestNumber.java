package com.strings;

import java.util.Arrays;
import java.util.Iterator;

public class LargestNumber {

	public static void main(String[] args) {

		int[] nums = { 0, 0 };

//		432, 43243  43243 243 ,, 43243 432

		System.out.println(new LargestNumber().largestNumber(nums));
	}

	public static String repeater(String s, int length) {

		StringBuilder sb = new StringBuilder();

		while (length > 0) {

			sb.append(s);

			length = length - sb.length();

		}

		return sb.toString();
	}

	public static int compareStrings(String a, String b) {

		int n1 = a.length();
		int n2 = b.length();

		for (int i = 0; i < Math.min(n1, n2); i++) {

			char c1 = a.charAt(i);
			char c2 = b.charAt(i);

			if (c1 < c2) {
				return 1;
			}

			if (c1 > c2) {
				return -1;
			}

		}

		return 0;
	}

	public String largestNumber(int[] nums) {

		String[] s = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

		Arrays.sort(s, (a, b) -> {

			if (a.equals(b))
				return 0;
			else {

				String s1 = a + b;
				String s2 = b + a;

				for (int i = 0; i < s1.length(); i++) {

					char c1 = s1.charAt(i);
					char c2 = s2.charAt(i);

					if (c1 < c2)
						return 1;

					if (c1 > c2)
						return -1;

				}

				return 0;
			}
		});

		StringBuilder sb = new StringBuilder();

		for (String s1 : s) {
			sb.append(s1);
		}

		int i = 0;

		while (i < sb.length() - 1 && sb.charAt(i) == '0') {
			i++;
		}

		return sb.substring(i, sb.length());

	}

}
