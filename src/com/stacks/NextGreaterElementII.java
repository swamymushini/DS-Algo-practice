package com.stacks;

import java.util.Stack;

public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] arr) {
		
		Stack<Integer> st = new Stack<>();

		int[] res = new int[arr.length];
		boolean[] tracker = new boolean[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && arr[i] >= st.peek()) {
				st.pop();
			}

			if (st.isEmpty()) {
				st.push(arr[i]);
				res[i] = -1;
				tracker[i] = true;
			} else {
				res[i] = st.peek();
			}

			st.push(arr[i]);
		}

		for (int i = res.length - 1; i >= 0; i--) {

			if (tracker[i]) {

				while (!st.isEmpty() && arr[i] >= st.peek()) {
					st.pop();
				}

				if (st.isEmpty())
					break;

				res[i] = st.peek();

			}

		}

		return res;
	}
}
