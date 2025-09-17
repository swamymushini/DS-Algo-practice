package com.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII {

	public static void main2(String[] args) {

		Queue<Integer> qu = new LinkedList<>();

		int max = 0;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {

				if (qu.size() >= k) {
					Integer index = qu.poll();
					cur = i - index - 1;
				}

				qu.add(i);
			}

			cur++;

			max = Math.max(max, cur);
		}

		System.out.println(max);

	}

	static int[] arr = new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
	static int k = 3;

// { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0 };
	public static void main(String[] args) {

		int max = 0;
		int cur = 0;
		int zeros = 0;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 0) {

				if (k == 0) {
					cur = 0;
					continue;
				}

				if (zeros >= k) {
					index = getZeroIndex(index);
					zeros--;
					cur = i - index - 1;
				}

				zeros++;
			}

			cur++;

			max = Math.max(max, cur);
		}

		System.out.println(max);

	}

	static int getZeroIndex(int start) {

		while (start < arr.length) {
			start++;
			if (arr[start] == 0) {
				break;
			}

		}

		return start;
	}

}
