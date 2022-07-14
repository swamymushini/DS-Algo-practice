package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumPositivitySubArr {

	public static void main(String[] args) {

		int[] solve = new MaximumPositivitySubArr().solve(new int[] { 10, -1, 2, 3, -4, 100 });

		for (int i = 0; i < solve.length; i++) {
			System.out.print(solve[i]+",");
		}
	}

	public int[] solve(int[] A) {

		List<Integer> arr = new ArrayList<Integer>();

		List<Integer> temp = new ArrayList<Integer>();

		int n = A.length;

		for (int i = 0; i < n; i++) {

			if (A[i] < 0) {

				if (temp.size() > arr.size()) {
					arr.clear();
					arr.addAll(temp);
					temp = new ArrayList<Integer>();
				}

				temp.clear();
				continue;
			}

			temp.add(A[i]);
		}

		if (temp.size() > arr.size()) {
			return listtoArray(temp);
		}

		return listtoArray(arr);
	}

	private int[] listtoArray(List<Integer> arr) {

		int[] arr1 = new int[arr.size()];

		for (int j = 0; j < arr.size(); j++)
			arr1[j] = arr.get(j);

		return arr1;
	}
}
