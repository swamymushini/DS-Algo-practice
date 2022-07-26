package com.stacks;

import java.util.Stack;

import com.util.Util;

public class NearestLargestElement {
	
	public static void main(String[] args) {
		int[] solve = new NearestLargestElement().prevLarger(new int[] {2,1,5,6,2,3});
		Util.printArray(solve);
	}

	public int[] prevLarger(int[] A) {

		Stack<Integer> stack = new Stack<>();
		int[] nsr = new int[A.length];

		for (int i = A.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				nsr[i] = stack.peek();
			} else {
				nsr[i] = A.length;
			}
			stack.push(i);
		}

		return nsr;
	}

}
