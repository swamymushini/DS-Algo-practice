package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class AlternatingSubarrays {

	public static void main(String[] args) {

		int[] solve = new AlternatingSubarrays().solve(new int[] { 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1,
				0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 }, 2);

	}

	List<Integer> al = new ArrayList<>();

	public int[] solve(int[] A, int B) {

		if (B == 0) {
			for (int i = 0; i < A.length; i++) {
				al.add(i);
			}
			return al.stream().mapToInt(i -> i).toArray();
		}

		int st = 0;
		int end = 0;

		for (int i = 1; i < A.length; i++) {

			if (A[i - 1] == A[i]|| i == A.length - 1) {

				if (i == A.length - 1 && A[i - 1] + A[i] == 1) {
					end = i;
				}

				int len = end - st + 1;

				if (len >= 3) {
					findPattern(st, end, B);
					System.out.println(st + "->" + end);
				}
				st = i;
			} else {
				end = i;
			}

		}

		System.out.println(al);

		return al.stream().mapToInt(i -> i).toArray();

	}

	void findPattern(int st, int end, int B) {
		int len = end - st + 1;
		int od = 2 * B + 1;

		if (len < od) {
			return;
		}

		int i = len - od;

		int mid = od / 2;
		al.add(st + mid);

		while (i-- > 0) {
			al.add(st + ++mid);
		}

	}

}
