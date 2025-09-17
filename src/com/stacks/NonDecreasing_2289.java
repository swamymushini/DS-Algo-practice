package com.stacks;

import java.util.Stack;

public class NonDecreasing_2289 {

	public static void main(String[] args) {
		int[] arr = new int[] { 14, 8, 8, 13, 2, 6, 13 };
//		int[] arr = new int[] { 4, 5, 7, 7, 13 };
//		int[] arr = new int[] { 10, 1, 2, 3, 6, 3, 4 };
//		int[] arr = new int[] { 10, 1, 2, 3, 4, 5, 6, 1, 2, 3 };

		int totalSteps = totalSteps(arr);
		System.out.println(totalSteps);
	}

	static int totalSteps(int[] nums) {
		Stack<Integer> st = new Stack<>();

		for (Integer num : nums) {
			st.push(num);
		}

		int count = 0;
		int res = 0;
		int carry = 0;

		while (!st.isEmpty()) {

			Integer pop = st.pop();

			if (st.isEmpty()) {
				break;
			}

			if (pop >= st.peek()) {
				count++;
			} else {
				count++;
				res = Math.max(count, res);
				count = 0;
			}

		}

		res = Math.max(count + carry, res);

		return res;
	}

}
