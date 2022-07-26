package com.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.util.Util;

public class MaximumFrequencyStack {

	public static void main(String[] args) {
		int[] solve = new MaximumFrequencyStack().solve(new int[][] { { 1, 5 }, { 1, 7 }, { 2, 0 }, { 1, 7 }, { 1, 4 },
				{ 1, 5 }, { 2, 0 }, { 2, 0 }, { 1,5 }, { 2, 0 } });
		Util.printArray(solve);
	}
	
	Map<Integer, Integer> countMap = new HashMap<>();
	Map<Integer, Stack<Integer>> countList = new HashMap<>();
	int max = 0;

	public int[] solve(int[][] A) {

		int[] res = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			if (A[i][0] == 1) {
				push(A[i][1]);
				res[i] = -1;
			} else {
				res[i] = pop();
			}
		}

		return res;
	}

	private void push(int x) {

		int count = countMap.getOrDefault(x, 0) + 1;
		Stack<Integer> st = null;

		if (count > max) {
			max = count;
			st = new Stack<>();
			countList.put(count, st);
		} else {
			st = countList.get(count);
		}

		st.push(x);
		countMap.put(x, count);
	}

	private int pop() {

		if (countList.isEmpty())
			return -1;

		Stack<Integer> stack = countList.get(max);

		if (stack.isEmpty())
			return -1;

		int val = stack.pop();

		if (stack.isEmpty()) {
			countList.remove(max);
			max--;
		}

		countMap.put(val, countMap.get(val) - 1);

		return val;
	}
}
