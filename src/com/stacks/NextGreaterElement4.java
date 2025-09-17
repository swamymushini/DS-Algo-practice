package com.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement4 {

	public static void main(String[] args) {
		int[] secondGreaterElement = new NextGreaterElement4().secondGreaterElement(new int[] { 2, 4, 8, 9, 4, 6 });
		Arrays.stream(secondGreaterElement).forEach(System.out::println);
	}

	public int[] secondGreaterElement(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);

		Stack<Integer> firstStack = new Stack<>();
		Stack<Integer> secondStack = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!secondStack.isEmpty() && nums[secondStack.peek()] < nums[i]) {
				res[secondStack.pop()] = nums[i];
			}

			Stack<Integer> temp = new Stack<>();
			while (!firstStack.isEmpty() && nums[firstStack.peek()] < nums[i]) {
				temp.push(firstStack.pop());
			}
			while (!temp.isEmpty()) {
				secondStack.push(temp.pop());
			}

			// Push current index to the first stack
			firstStack.push(i);
		}

		try {

			return res;
		} catch (Exception e) {
		} finally {
			System.out.println();
			return null;
		}

	}

}
