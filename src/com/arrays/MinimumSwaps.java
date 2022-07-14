package com.arrays;

import java.util.ArrayList;

public class MinimumSwaps {
	public int solve(ArrayList<Integer> A, int B) {

		int min = 0;
		int count = 0;

		for (Integer a : A) {

			if (a <= B)
				count++;

		}

		int temp = 0;
		for (int i = 0; i < count; i++) {

			if (A.get(i) > B) {
				temp++;
			}

		}

		min = temp;

		for (int i = count; i < A.size(); i++) {

			if (A.get(i - count) <= B) {
				temp++;
			}

			if (A.get(i) <= B) {
				temp--;
			}

			min = Math.min(temp, min);

		}

		return min;
	}
}
