package com.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		System.out.println(new BalancedParanthesis().solve("{([])}"));
	}

	public int solve(String A) {
		Map<Character, Character> mp = new HashMap<Character, Character>();
		Stack<Character> st = new Stack<Character>();
		mp.put(')', '(');
		mp.put('}', '{');
		mp.put(']', '[');
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (!mp.containsKey(c)) {
				st.push(c);
			} else if (st.empty() || st.peek() != mp.get(c)) {
				return 0;
			} else {
				st.pop();
			}
		}

		if (!st.isEmpty())
			return 0;

		return 1;
	}
}
