package com.stacks;

import java.util.Stack;

public class MAXMINDifference {

	public int solve(int[] A) {

		long ans = 0;
		int mod = (int) Math.pow(10, 9) + 7;

		int[] nsl = nearestSmallLeft(A);
		int[] nsr = nearestSmallRight(A);
		int[] nll = nearestLargeLeft(A);
		int[] nlr = nearestLargeRight(A);

		long max = 0;
		long min = 0;

		for (int i = 0; i < A.length; i++) {
			min = ((long) (i - nsl[i])) * (nsr[i] - i);
			min *= A[i];

			max = ((long) (i - nll[i])) * (nlr[i] - i);
			max *= A[i];

			ans += (max - min);

		}

		if (ans < 0) {
			ans = (ans + mod) % mod;
		}
		ans %= mod;
		return (int) ans;
	}

	public int[] nearestSmallLeft(int[] A) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[A.length];

		for (int i = 0; i < A.length; i++) {

			while (!st.isEmpty() && A[st.peek()] >= A[i])
				st.pop();

			if (st.isEmpty()) {
				res[i] = -1;
			} else
				res[i] = st.peek();

			st.push(i);

		}

		return res;
	}

	public int[] nearestSmallRight(int[] A) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[A.length];

		for (int i = A.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && A[st.peek()] >= A[i])
				st.pop();

			if (st.isEmpty())
				res[i] = A.length;
			else
				res[i] = st.peek();

			st.push(i);

		}

		return res;
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
