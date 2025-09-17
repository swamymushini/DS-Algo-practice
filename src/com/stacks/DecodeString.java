package com.stacks;

import java.util.Stack;

class DecodeString {

	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("10[gopal]"));
	}

	public String decodeString(String s) {

		Stack<String> st = new Stack<>();

		Stack<Integer> numbers = new Stack<>();
		numbers.forEach(null);

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {

				String num = c + "";

				while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					num = s.charAt(i + 1) + num;
					i++;
				}

				numbers.add(Integer.valueOf(num));

				st.add(" ");
				i++;
			} else if (c == ']') {
				String s2 = "";

				while (st.peek() != " ") {
					s2 = st.pop() + s2;
				}

				st.pop();

				st.push(repeater(s2, numbers.pop()));
			} else {
				st.push(c + "");
			}

		}

		StringBuilder sb = new StringBuilder();

		while (!st.isEmpty()) {
			sb.insert(0, st.pop());
		}

		return sb.toString();

	}

	String repeater(String s, int n) {

		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			sb.append(s);
		}

		return sb.toString();
	}

}