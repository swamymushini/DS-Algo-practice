package com.stacks;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		System.out.println(new RemoveKDigits().removeKdigits("10001", 4));
	}

	public String removeKdigits(String num, int k) {

		if (k == num.length())
			return "0";

		StringBuilder sb = new StringBuilder();

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < num.length(); i++) {

			char c = num.charAt(i);
			int val = Character.getNumericValue(c);

			while (!st.isEmpty() && st.peek() > val && k > 0) {
				k--;
				st.pop();
			}

			st.push(val);
		}

		if (st.isEmpty())
			return "0";

		while (!st.isEmpty() && k > 0) {
			st.pop();
			k--;
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		String strPattern = "^0+(?!$)";
		return sb.reverse().toString().replaceAll(strPattern, "");
	}

}