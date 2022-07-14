package com.arrays;

import java.util.ArrayList;

public class PrefixMatrix {

	public static void main(String[] args) {

		int[] a = new int[] { 1, 1, 1, 1, 1 };

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> array_list = new ArrayList<Integer>();

		int j = 5;
		while (j-- > 0) {

			for (int i = 0; i < a.length; i++)
				array_list.add(new Integer(a[i]));

			res.add(new ArrayList<Integer>(array_list));
			array_list.clear();
		}

		System.out.println(new PrefixMatrix().solve(res));
	}

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

		for (int i = 0; i < A.size(); i++) {

			ArrayList<Integer> arr = A.get(i);

			for (int j = 1; j < A.get(0).size(); j++) {
				arr.set(j, arr.get(j - 1) + arr.get(j));
			}
		}

		for (int j = 0; j < A.get(0).size(); j++) {
			
			for (int i = 1; i < A.size(); i++) {
				A.get(i).set(j, A.get(i-1).get(j) + A.get(i).get(j));
			}
		}

		return A;
	}

}
