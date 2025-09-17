package com.stacks;

import java.util.Stack;

class DailyTemperatures {

	static class Node {
		int val;
		int index;

		public Node(int val, int index) {
			this.val = val;
			this.index = index;
		}

	}

	public int[] dailyTemperatures(int[] temps) {

		Stack<Node> st = new Stack<>();

		int[] res = new int[temps.length];

		st.add(new Node(temps[temps.length - 1], temps.length - 1));

		for (int i = temps.length - 2; i >= 0; i--) {

			Node node = st.peek();

			int a = temps[i];

			if (node.val > a) {

				st.add(new Node(node.val, i));

			} else {

				while (!st.isEmpty() && st.peek().val < a) {
					st.pop();
				}

				st.add(new Node(node.val, i));
			}

			res[i] = st.peek().index - i;

		}

		return res;
	}

}