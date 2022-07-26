package com.stacks;

import java.util.Stack;

public class BracketExpressions {

	public static void main(String[] args) {
		System.out.println(new BracketExpressions().solve("a+b-c+d-e", "(a+b-c+d-e)"));
	}

	public int solve(String A, String B) {

		Stack<Character> a = new Stack<>();
		Stack<Character> b = new Stack<>();

		boolean reverse = false;

		for (int i = 0; i < A.length(); i++) {

			char c = A.charAt(i);

			if (c == '(') {
				if (!a.isEmpty() && a.peek() == '-') {
					reverse = true;
				}

				continue;
			}

			if (c == ')') {
				reverse = false;
				continue;
			}

			if (c == '+') {
				c = reverse ? '-' : '+';
			}

			if (c == '-') {
				c = reverse ? '+' : '-';
			}

			a.push(c);

		}

		reverse = false;

		for (int i = 0; i < B.length(); i++) {

			char c = B.charAt(i);

			if (c == '(') {

				if (!b.isEmpty() && b.peek() == '-') {
					reverse = true;
				}

			}

			if (c == ')') {
				reverse = false;
			}

			if (c == '+') {
				c = reverse ? '-' : '+';
			}

			if (c == '-') {
				c = reverse ? '+' : '-';
			}

			b.push(c);

		}

		while (!a.isEmpty() && !b.isEmpty()) {

			if (a.pop() != b.pop())
				return 0;

		}

		return (!a.isEmpty() && !b.isEmpty()) ? 0 : 1;
	}
}
