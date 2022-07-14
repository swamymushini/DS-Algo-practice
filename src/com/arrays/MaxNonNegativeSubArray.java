package com.arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {

		int[] a = new int[] { 756898537, -1973594324, -2038664370, -184803526, 1424268980 };

		ArrayList<Integer> array_list = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++)
			array_list.add(new Integer(a[i]));

		System.out.println(new MaxNonNegativeSubArray().maxset(array_list));
	}

	ArrayList<Integer> maxset(ArrayList<Integer> A) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		ArrayList<Integer> temp = new ArrayList<Integer>();

		long max = -1;
		long sum = 0;

		for (int i = 0; i < A.size(); i++) {

			if (A.get(i) < 0) {

				sum = 0;
				temp.clear();
				continue;
			}

			sum += A.get(i);
			temp.add(A.get(i));

		}

		if (sum > max) {
			return temp;
		}

		return res;
	}
}
