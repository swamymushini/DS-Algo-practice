package com.arrays;

import java.util.ArrayList;

public class Flip {

//	https://www.scaler.com/academy/mentee-dashboard/class/25341/homework/problems/329?navref=cl_tt_lst_nm

	public static void main(String[] args) {
		System.out.println(new Flip().flip("0011101"));
	}

	public ArrayList<Integer> flip(String A) {

		int sum = 0;
		int ind = 0;

		ArrayList<Integer> res = new ArrayList<Integer>();

		int max = 0;

		for (int i = 0; i < A.length(); i++) {

			char c = A.charAt(i);

			if (c == '1')
				sum--;
			else
				sum++;

			if (sum < 0) {
				sum = 0;
				ind = i + 1;
			}

			if (sum > max) {
				max = sum;
				res.add(0, ind + 1);
				res.add(1, i + 1);
			}

		}

		return res;
	}

}
