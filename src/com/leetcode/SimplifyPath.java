package com.leetcode;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/../..ga//b/.f..d/..../e.baaeeh./.a"));
	}

	public String simplifyPath(String s) {

		StringBuilder sb = new StringBuilder();

		Stack<String> stack = new Stack<>();

		String[] arr = s.split("/");

		for (String a : arr) {

			if (a.equals("..")) {

				if (!stack.isEmpty())
					stack.pop();

			} else if (a.equals(".")) {
				continue;
			} else if (!a.equals("") && !a.equals(" ")) {
				stack.push(a);
			}

		}

		if (stack.isEmpty())
			return "/";
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop()).insert(0, "/");
		}

		return sb.toString();
	}

}