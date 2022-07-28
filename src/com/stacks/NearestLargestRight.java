package com.stacks;

import java.util.Stack;

import com.util.Util;

public class NearestLargestRight {
	public static void main(String[] args) {
		Util.printArray(new NearestLargestRight().nearestLargeRight(new int[] {}));
	}

	public int[] nearestLargeRight(int[] A) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[A.length];

		for (int i = A.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && A[st.peek()] <= A[i])
				st.pop();

			if (st.isEmpty())
				res[i] = A.length;
			else
				res[i] = st.peek();

			st.push(i);

		}

		return res;
	}

}
