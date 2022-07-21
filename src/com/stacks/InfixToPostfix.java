package com.stacks;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(new InfixToPostfix().solve("q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)"));
//		qct*o*+gg*+qia-*p*+il*-
//		qct*o*+gg*+qia-*p*+il*-
		
	}

	public String solve(String A) {

		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('(', 4);
		map.put(')', 4);
		map.put('^', 3);
		map.put('/', 2);
		map.put('*', 2);
		map.put('+', 1);
		map.put('-', 1);

		for (int i = 0; i < A.length(); i++) {

			char ch = A.charAt(i);

			if (map.containsKey(ch)) {

				if (!st.isEmpty() && st.peek() != '(') {

					int input = map.get(ch);

					if (ch == ')') {

						while (st.peek() != '(')
							sb.append(st.pop());

						st.pop();
						continue;
					}

					while (!st.isEmpty() && input <= map.get(st.peek())&&st.peek() != '(') {
							sb.append(st.pop());
						}	

				}
				st.push(ch);
			} else
				sb.append(ch);
		}

		while (!st.isEmpty())
			sb.append(st.pop());

		return sb.toString();
	}
}
