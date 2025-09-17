package com.backtracking;

import java.util.*;

public class CombinationsPhoneNumberLetters {

	public static void main(String[] args) {
		System.out.println(new CombinationsPhoneNumberLetters().letterCombinations("37"));
	}

	String[] sr = new String[8];

	public List<String> letterCombinations(String digits) {
		
		sr[0] = "abc";
		sr[1] = "def";
		sr[2] = "ghi";
		sr[3] = "jkl";
		sr[4] = "mno";
		sr[5] = "pqrs";
		sr[6] = "tuv";
		sr[7] = "wxyz";

		List<String> res = new ArrayList<>();

		letterCombinations(digits, res, new StringBuilder(), 0);

		return res;
	}

	public void letterCombinations(String digits, List<String> res, StringBuilder curr, int curLetter) {

		if (curr.length() == digits.length()) {
			res.add(curr.toString());
			return;
		}

		char c = digits.charAt(curLetter);

		int number = Character.getNumericValue(c);

		String letters = sr[number - 2];

		for (int j = 0; j < letters.length(); j++) {
			char c2 = letters.charAt(j);
			curr.append(c2);
			letterCombinations(digits, res, curr, curLetter + 1);
			curr.deleteCharAt(curr.length() - 1);
		}

	}
}
