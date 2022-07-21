package com.stacks;

import java.util.Stack;

public class TwoBracketExpressions {

	public static void main(String[] args) {
		System.out.println(new TwoBracketExpressions().solve("-(a+((b-c)-(d+e)))", "-(a+b-c-d-e)"));
	}

	Boolean adjSign(String s, int i) {
		if (i == 0)
			return true;
		if (s.charAt(i - 1) == '-')
			return false;
		return true;
	};

	public int solve(String A, String B) {

		boolean[] a = evaluate(A);
		boolean[] b = evaluate(B);

		for (int i = 0; i < b.length; i++) {
			if (a[i] != b[i]) {
				return 0;
			}
		}

		return 1;
	}

	private boolean[] evaluate(String A) {
		boolean[] a = new boolean[5];

		Stack<Boolean> st = new Stack<>();
		st.push(true);
		for (int i = 0; i < A.length(); i++) {

			char ch = A.charAt(i);

			if (ch == '+' || ch == '-') {
				continue;
			} else if (ch == '(') {

				Boolean sign = adjSign(A, i);
				if (sign) {
					st.push(st.peek());
				} else
					st.push(!st.peek());

			} else if (ch == ')') {
				st.pop();
			} else {
				Boolean sign = adjSign(A, i);

				if (sign) {
					a[ch - 'a'] = st.peek();
				} else if (!st.peek()) {
					a[ch - 'a'] = true;
				}

			}
		}

		return a;
	}
}
