package com.strings;

import com.util.Util;

public class StringCompression {

	public static void main(String[] args) {

		char[] c = { 'a', 'a', 'b', 'b', 'c' };

		new StringCompression().compress(c);

		Util.printArray(c);
	}

	public int compress(char[] chars) {

		int currCount = 0;
		int charIndex = 0;

		for (int i = 1; i < chars.length; i++) {

			char c = chars[i];

			if (chars[charIndex] == c) {

				currCount++;

			} else {

				if (currCount > 0) {
					String countStr = (currCount + 1) + "";
					for (char c2 : countStr.toCharArray()) {
						chars[++charIndex] = c2;
					}
					currCount = 0;
				}

				chars[++charIndex] = c;
			}

		}

		if (currCount > 0) {
			chars[++charIndex] = (char) (currCount + 1);
		}

		return charIndex + 1;
	}

}
