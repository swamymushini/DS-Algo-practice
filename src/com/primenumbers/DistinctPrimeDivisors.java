package com.primenumbers;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DistinctPrimeDivisors {

	public static void main(String[] args) {
		System.out.println(new DistinctPrimeDivisors().solve(new int[] { 1, 20 }));
	}

	public int solve(int[] A) {

		Set<Integer> res = new HashSet<>();

		int max = 0;

		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}

		Stack<Integer>[] SPF = new Stack[max + 1];

		SPF[1] = null;
		SPF[0] = null;

		for (int i = 2; i <= max; i++) {

			if (SPF[i] == null) {
				for (int j = i + i; j <= max; j += i) {
					Stack<Integer> stack = SPF[j];
					if (stack == null) {
						stack = new Stack<>();
					}
					stack.push(i);
					SPF[j] = stack;
				}
			}
		}

		return 0;
	}

}
