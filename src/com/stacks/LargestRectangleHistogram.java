package com.stacks;

import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		System.out.println(new LargestRectangleHistogram()
				.largestRectangleArea(new int[] { 90, 58, 69, 70, 82, 100, 13, 57, 47, 18 }));
	}

	public int largestRectangleArea(int[] A) {

		int max = 0;

		int[] nsl = nearestSmallLeft(A);
		int[] nsr = nearestSmallRight(A);

		for (int i = 0; i < A.length; i++) {

			int val = A[i];

			int s = nsl[i];
			int e = nsr[i];

			int wid = e - s - 1;
			wid = Math.abs(wid);

			max = Math.max(wid * val, max);

		}

		return max;
	}

	public int[] nearestSmallLeft(int[] A) {

		int[] res = new int[A.length];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < A.length; i++) {

			int val = A[i];

			while (!st.isEmpty() && A[st.peek()] >= val)
				st.pop();

			if (st.isEmpty())
				res[i] = i - 1;
			else
				res[i] = st.peek();

			st.push(i);
		}

		return res;
	}

	public int[] nearestSmallRight(int[] A) {

		int[] res = new int[A.length];
		Stack<Integer> st = new Stack<>();

		for (int i = A.length - 1; i >= 0; i--) {
			int val = A[i];

			while (!st.isEmpty() && A[st.peek()] >= val)
				st.pop();

			if (st.isEmpty())
				res[i] = i + 1;
			else
				res[i] = st.peek();

			st.push(i);
		}

		return res;
	}

}
