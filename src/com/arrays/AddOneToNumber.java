package com.arrays;

import java.util.ArrayList;

public class AddOneToNumber {

	public static void main(String[] args) {

		int[] a = new int[] { 1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5 };

		ArrayList<Integer> array_list = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++)
			array_list.add(new Integer(a[i]));

		System.out.println(new AddOneToNumber().plusOne(array_list));
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		long val = 0;
		long tens = 1;

		for(int i=A.size()-1;i>=0;i--){

			long num = A.get(i) * tens;

			val = val + num;

			tens = tens * 10;
		}

		val++;

		String s = "" + val;

		for (int i = 0; i < s.length(); i++) {

			res.add(Character.getNumericValue(s.charAt(i)));

		}

		return res;
	}
}
