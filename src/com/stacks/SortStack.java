package com.stacks;

import java.util.Stack;

import com.util.Util;

public class SortStack {

	public static void main(String[] args) {
		Util.printArray(new SortStack()
				.solve(new int[] { 1, 4, 6, 11, 12, 14, 22, 28, 41, 42, 43, 43, 66, 70, 70, 76, 78, 81, 88, 90, 96 }));
	}

	public int[] solve(int[] A) {

		Stack<Integer> st = new Stack<>();

		for (int a : A)
			st.push(a);

		st = mergeSort(st);

		for (int i = 0; i < A.length; i++) {
			A[i] = st.pop();
		}

		return A;

	}

	private Stack<Integer> mergeSort(Stack<Integer> st) {

		if (st.size() <= 1) {
			return st;
		}

		Stack<Integer> top = getHalf(st);
		Stack<Integer> bottom = getFull(st);

		top = mergeSort(top);
		bottom = mergeSort(bottom);

		return merge(top, bottom);
	}

	private Stack<Integer> getHalf(Stack<Integer> st) {

		Stack<Integer> st2 = new Stack<>();

		int len = st.size();

		for (int i = 0; i < len / 2; i++)
			st2.push(st.pop());

		return st2;
	}

	private Stack<Integer> getFull(Stack<Integer> st) {

		Stack<Integer> st2 = new Stack<>();

		int len = st.size();

		for (int i = 0; i < len; i++)
			st2.push(st.pop());

		return st2;
	}

	private Stack<Integer> merge(Stack<Integer> top, Stack<Integer> bot) {

		if (top == null || top.isEmpty()) {
			return bot;
		} else if (bot == null || bot.isEmpty()) {
			return top;
		}

		Stack<Integer> st = new Stack<>();

		while (!top.isEmpty() && !bot.isEmpty()) {

			if (top.peek() < bot.peek()) {
				st.push(top.pop());
			} else
				st.push(bot.pop());

		}

		while (!top.isEmpty()) {
			st.push(top.pop());
		}

		while (!bot.isEmpty()) {
			st.push(bot.pop());
		}
		
		 while(!st.isEmpty()){
	            top.add(st.pop());
	        }


		return top;
	}

}
