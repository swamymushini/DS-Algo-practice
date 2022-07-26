package com.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		System.out.println(new EvaluateExpression().evalRPN(new String[] { "4", "13", "5", "/", "+" }));
	}

	public int evalRPN(String[] A) {

		Stack<String> st = new Stack<>();

		Set<String> set = new HashSet<>();
		set.add("+");
		set.add("-");
		set.add("*");
		set.add("/");

		for (String ai : A) {

			if (set.contains(ai)) {

				int a = Integer.valueOf(st.pop());
				int b = Integer.valueOf(st.pop());

				int res1 = 0;
				if (ai.equals("+"))
					res1 = a + b;
				else if (ai.equals("*"))
					res1 = (a * b);
				else if (ai.equals("-"))
					res1 = (b - a);
				else if (ai.equals("/"))
					res1 = (b / a);

				st.push(res1 + "");

			} else
				st.push(ai);

		}

		return Integer.valueOf(st.pop());
	}
}
