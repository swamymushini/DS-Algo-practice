package com.stacks;

import java.util.Stack;

import com.util.Util;

public class NearestLargestLeft {
	public static void main(String[] args) {
		Util.printArray(new NearestLargestLeft().nearestLargeLeft(new int[] {}));
	}

	public int[] nearestLargeLeft(int[] A) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[A.length];

		for (int i = 0; i < A.length; i++) {

			while (!st.isEmpty() && A[st.peek()] <= A[i])
				st.pop();

			if (st.isEmpty())
				res[i] = -1;
			else
				res[i] = st.peek();

			st.push(i);

		}

		return res;
	}

}
