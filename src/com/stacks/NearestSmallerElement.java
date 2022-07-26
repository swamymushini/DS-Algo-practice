package com.stacks;

import java.util.Stack;

public class NearestSmallerElement {

	public int[] prevSmaller(int[] A) {

		Stack<Integer> st = new Stack<>();
		int[] res = new int[A.length];

		for (int i = 0; i < A.length; i++) {

			int val = A[i];

			while (!st.isEmpty() && st.peek() >= val)
				st.pop();

			if (st.isEmpty()) {
				res[i] = -1;
			} else if (st.peek() <= val) {
				res[i] = st.peek();
			}

			st.push(val);

		}

		return res;
	}

}
